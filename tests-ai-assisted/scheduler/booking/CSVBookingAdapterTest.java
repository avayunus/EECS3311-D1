package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import scheduler.data.CSVBookingAdapter;
import scheduler.model.Booking;
import scheduler.strategy.*;

public class CSVBookingAdapterTest {

    @TempDir
    public File tempFolder;

    private File tempCsvFile;
    private CSVBookingAdapter adapter;

    @BeforeEach
    public void setUp() throws IOException {
        tempCsvFile = new File(tempFolder, "test_bookings.csv");
        adapter = new CSVBookingAdapter(tempCsvFile.getAbsolutePath());
    }

    // --- UPDATED HAND-WRITTEN STUB FOR PRICING STRATEGY ---
    private static class StubPricingStrategy implements PricingStrategy {
        private final double hourlyRate;

        public StubPricingStrategy(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double getHourlyRate() {
            return this.hourlyRate;
        }

        @Override
        public double calculateCost(int hours) {
            return this.hourlyRate * hours;
        }
    }

    private void writeRawCsv(String content) throws IOException {
        try (FileWriter fw = new FileWriter(tempCsvFile)) {
            fw.write(content);
        }
    }

    // --- FIND ALL TESTS ---

    @Test
    public void testFindAll_fileDoesNotExist() {
        if (tempCsvFile.exists()) tempCsvFile.delete();

        List<Booking> results = adapter.findAll();
        assertNotNull(results);
        assertTrue(results.isEmpty(), "Should return an empty list gracefully if file is missing.");
    }

    @Test
    public void testFindAll_parsesStrategiesAndHandlesTrimming() throws IOException {
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n" +
                "1,RoomA,User1,09,10,faculty\n" +
                "2,RoomB,User2,11,12,  STAFF  \n" +
                "3,RoomC,User3,13,14,partner\n" +
                "4,RoomD,User4,15,16,student\n" +
                "5,RoomE,User5,17,18,unknown_type\n");

        List<Booking> bookings = adapter.findAll();

        assertEquals(5, bookings.size());
        assertTrue(bookings.get(0).getPricingStrategy() instanceof FacultyPricingStrategy);
        assertTrue(bookings.get(1).getPricingStrategy() instanceof StaffPricingStrategy);
        assertTrue(bookings.get(2).getPricingStrategy() instanceof PartnerPricingStrategy);
        assertTrue(bookings.get(3).getPricingStrategy() instanceof StudentPricingStrategy);
        assertTrue(bookings.get(4).getPricingStrategy() instanceof StudentPricingStrategy);
    }

    @Test
    public void testFindAll_readsCorrectBookingData() throws IOException {
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n" +
                "b-99,101,u-50, 9 , 17 ,student\n");

        List<Booking> bookings = adapter.findAll();
        assertEquals(1, bookings.size());

        Booking b = bookings.get(0);
        assertEquals("b-99", b.getId());
        assertEquals("101", b.getRoomId());
        assertEquals("u-50", b.getUserId());
        assertEquals(9, b.getStartHour());
        assertEquals(17, b.getEndHour());
    }

    @Test
    public void testFindAll_throwsExceptionOnMalformedData() throws IOException {
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n" +
                "1,RoomA,User1,nine,10,student\n");

        assertThrows(IllegalStateException.class, () -> {
            adapter.findAll();
        }, "Should throw an IllegalStateException wrap when parsing integers fails.");
    }

    // --- SAVE TESTS ---

    @Test
    public void testSave_nullBookingDoesNothing() {
        adapter.save(null);
        assertFalse(tempCsvFile.exists(), "Saving null should return instantly without creating a file.");
    }

    @Test
    public void testSave_insertsNewRecordsAndTranslatesRates() throws IOException {
        // Seeding the exact hourly rates (30, 40, 50) evaluated by the adapter logic
        Booking b1 = new Booking("id-fac", "R1", "U1", 8, 9, new StubPricingStrategy(30.0));
        Booking b2 = new Booking("id-stu", "R2", "U2", 14, 15, new StubPricingStrategy(0.0));

        adapter.save(b1);
        adapter.save(b2);

        List<Booking> saved = adapter.findAll();
        assertEquals(2, saved.size());

        List<String> lines = Files.readAllLines(tempCsvFile.toPath());
        assertTrue(lines.contains("id-fac,R1,U1,8,9,faculty"));
        assertTrue(lines.contains("id-stu,R2,U2,14,15,student"));
    }

    @Test
    public void testSave_updatesExistingRecordWithoutDuplicates() throws IOException {
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n" +
                "b-1,OldRoom,User1,9,10,student\n");

        Booking updated = new Booking("b-1", "NewRoom", "User1", 10, 12, new StubPricingStrategy(40.0));
        adapter.save(updated);

        List<Booking> current = adapter.findAll();
        assertEquals(1, current.size(), "Should replace the old record rather than appending a duplicate entry.");
        assertEquals("NewRoom", current.get(0).getRoomId());
        assertTrue(current.get(0).getPricingStrategy() instanceof StaffPricingStrategy);
    }

    // --- DELETE TESTS ---

    @Test
    public void testDelete_idExistsRemovesRecord() throws IOException {
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n" +
                "del-me,R1,U1,9,10,student\n" +
                "keep-me,R2,U2,11,12,partner\n");

        adapter.delete("del-me");

        List<Booking> current = adapter.findAll();
        assertEquals(1, current.size());
        assertEquals("keep-me", current.get(0).getId());
    }

    @Test
    public void testDelete_idDoesNotExistLeavesFileUntouched() throws IOException {
        String baseContent = "id,roomId,userId,startHour,endHour,userType\n" +
                "keep-me,R2,U2,11,12,partner\n";
        writeRawCsv(baseContent);

        adapter.delete("non-existent-id");

        String actualContent = new String(Files.readAllBytes(tempCsvFile.toPath()));
        assertEquals(baseContent.trim(), actualContent.trim(), "File should remain completely untouched if no matching ID is found.");
    }
}
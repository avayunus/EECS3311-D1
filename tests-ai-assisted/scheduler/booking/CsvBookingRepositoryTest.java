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

import scheduler.data.CsvBookingRepository;
import scheduler.model.Booking;
import scheduler.strategy.*;

public class CsvBookingRepositoryTest {

    @TempDir
    public File tempFolder;

    private File tempCsvFile;
    private CsvBookingRepository repository;

    @BeforeEach
    public void setUp() throws IOException {
        tempCsvFile = new File(tempFolder, "bookings_cache.csv");
        // Start with an empty file so the constructor loads cleanly
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n");
        repository = new CsvBookingRepository(tempCsvFile.getAbsolutePath());
    }

    // --- HAND-WRITTEN STUB FOR PRICING STRATEGY ---
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

    // --- CONSTRUCTOR & LOAD TESTS ---

    @Test
    public void testConstructor_fileDoesNotExist() {
        File missingFile = new File(tempFolder, "does_not_exist.csv");
        // Should initialize gracefully without throwing an exception
        CsvBookingRepository repo = new CsvBookingRepository(missingFile.getAbsolutePath());
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    public void testLoad_parsesAllUserTypesAndTrims() throws IOException {
        writeRawCsv("id,roomId,userId,startHour,endHour,userType\n" +
                "1,RoomA,User1,08,09,faculty\n" +
                "2,RoomB,User2,10,11,  STAFF  \n" +
                "3,RoomC,User3,12,13,partner\n" +
                "4,RoomD,User4,14,15,student\n" +
                "5,RoomE,User5,16,17,unknown_fallback\n");

        // Reinstate repository to prompt constructor loading phase
        CsvBookingRepository repo = new CsvBookingRepository(tempCsvFile.getAbsolutePath());
        List<Booking> loaded = repo.findAll();

        assertEquals(5, loaded.size());
        assertTrue(loaded.get(0).getPricingStrategy() instanceof FacultyPricingStrategy);
        assertTrue(loaded.get(1).getPricingStrategy() instanceof StaffPricingStrategy);
        assertTrue(loaded.get(2).getPricingStrategy() instanceof PartnerPricingStrategy);
        assertTrue(loaded.get(3).getPricingStrategy() instanceof StudentPricingStrategy);
        assertTrue(loaded.get(4).getPricingStrategy() instanceof StudentPricingStrategy);
    }

    @Test
    public void testLoad_throwsExceptionOnMalformedData() throws IOException {
        // Create a distinct file for the exception to avoid file-locking test teardown errors
        File malformedFile = new File(tempFolder, "malformed_bookings.csv");
        try (FileWriter fw = new FileWriter(malformedFile)) {
            fw.write("id,roomId,userId,startHour,endHour,userType\n" +
                    "b-err,RoomX,UserX,abc,12,student\n");
        }

        assertThrows(IllegalStateException.class, () -> {
            new CsvBookingRepository(malformedFile.getAbsolutePath());
        }, "Should throw IllegalStateException when fields like startHour fail to parse as an Integer.");
    }

    // --- FIND ALL TESTS ---

    @Test
    public void testFindAll_returnsDefensiveCopy() {
        Booking b = new Booking("id-1", "Room1", "User1", 9, 10, new StubPricingStrategy(0.0));
        repository.save(b);

        List<Booking> snapshot1 = repository.findAll();
        List<Booking> snapshot2 = repository.findAll();

        assertNotSame(snapshot1, snapshot2, "findAll must return a new list reference every call.");
        assertEquals(1, snapshot1.size());
    }

    // --- SAVE TESTS ---

    @Test
    public void testSave_nullBookingDoesNothing() {
        repository.save(null);
        List<Booking> current = repository.findAll();
        assertTrue(current.isEmpty());
    }

    @Test
    public void testSave_insertsNewRecordAndSerializesRates() throws IOException {
        Booking facultyBooking = new Booking("fac-1", "R1", "U1", 9, 10, new StubPricingStrategy(30.0));
        Booking studentBooking = new Booking("stu-1", "R2", "U2", 11, 12, new StubPricingStrategy(0.0));

        repository.save(facultyBooking);
        repository.save(studentBooking);

        assertEquals(2, repository.findAll().size());

        List<String> lines = Files.readAllLines(tempCsvFile.toPath());
        assertTrue(lines.contains("fac-1,R1,U1,9,10,faculty"));
        assertTrue(lines.contains("stu-1,R2,U2,11,12,student"));
    }

    @Test
    public void testSave_updatesExistingRecordInPlace() {
        Booking initial = new Booking("id-1", "OldRoom", "User1", 9, 10, new StubPricingStrategy(40.0));
        repository.save(initial);

        // Save matching ID with altered properties
        Booking updated = new Booking("id-1", "NewRoom", "User1", 14, 16, new StubPricingStrategy(50.0));
        repository.save(updated);

        List<Booking> current = repository.findAll();
        assertEquals(1, current.size(), "Cache replacement must avoid expanding the list size.");
        assertEquals("NewRoom", current.get(0).getRoomId());
        assertEquals(14, current.get(0).getStartHour());
    }

    // --- DELETE TESTS ---

    @Test
    public void testDelete_idExistsRemovesAndReWrites() throws IOException {
        Booking b1 = new Booking("id-keep", "R1", "U1", 9, 10, new StubPricingStrategy(0.0));
        Booking b2 = new Booking("id-del", "R2", "U2", 11, 12, new StubPricingStrategy(0.0));

        repository.save(b1);
        repository.save(b2);

        repository.delete("id-del");

        List<Booking> current = repository.findAll();
        assertEquals(1, current.size());
        assertEquals("id-keep", current.get(0).getId());

        List<String> lines = Files.readAllLines(tempCsvFile.toPath());
        assertFalse(lines.stream().anyMatch(l -> l.contains("id-del")), "The deleted record should be absent from disk.");
    }

    @Test
    public void testDelete_idDoesNotExistLeavesFileUntouched() throws java.io.IOException {
        Booking b = new Booking("id-keep", "R1", "U1", 9, 10, new StubPricingStrategy(0.0));
        repository.save(b);

        long beforeDeleteTimestamp = tempCsvFile.lastModified();

        // Attempt removing non-existent record
        repository.delete("non-existent-id");

        assertEquals(1, repository.findAll().size());
        assertEquals("id-keep", repository.findAll().get(0).getId());
    }
}
package scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import scheduler.data.CSVBookingAdapter;
import scheduler.model.Booking;
import scheduler.strategy.FacultyPricingStrategy;
import scheduler.strategy.StudentPricingStrategy;

public class CSVBookingAdapterTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File testCsvFile;
    private CSVBookingAdapter adapter;

    @Before
    public void setUp() throws IOException {
        testCsvFile = tempFolder.newFile("test_bookings.csv");
        adapter = new CSVBookingAdapter(testCsvFile.getAbsolutePath());
    }

    @Test
    public void testFindAllNonExistentFileReturnsEmptyList() {
        CSVBookingAdapter invalidAdapter = new CSVBookingAdapter("non_existent_path.csv");
        List<Booking> bookings = invalidAdapter.findAll();
        assertNotNull(bookings);
        assertTrue(bookings.isEmpty());
    }

    @Test
    public void testSaveAndFindAllSingleBooking() {
        Booking booking = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        adapter.save(booking);

        List<Booking> list = adapter.findAll();
        assertEquals(1, list.size());
        assertEquals("B100", list.get(0).getId());
        assertEquals("R101", list.get(0).getRoomId());
        assertEquals("U101", list.get(0).getUserId());
        assertEquals(9, list.get(0).getStartHour());
        assertEquals(11, list.get(0).getEndHour());
    }

    @Test
    public void testSaveNullBookingDoesNothing() {
        adapter.save(null);
        assertTrue(adapter.findAll().isEmpty());
    }

    @Test
    public void testSaveUpdateExistingBooking() {
        Booking initial = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        adapter.save(initial);

        Booking updated = new Booking("B100", "R101", "U101", 10, 12, new FacultyPricingStrategy());
        adapter.save(updated);

        List<Booking> list = adapter.findAll();
        assertEquals(1, list.size());
        assertEquals(10, list.get(0).getStartHour());
        assertEquals(12, list.get(0).getEndHour());
    }

    @Test
    public void testDeleteBooking() {
        Booking b1 = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        Booking b2 = new Booking("B200", "R102", "U102", 12, 14, new FacultyPricingStrategy());
        adapter.save(b1);
        adapter.save(b2);

        adapter.delete("B100");
        List<Booking> list = adapter.findAll();
        assertEquals(1, list.size());
        assertEquals("B200", list.get(0).getId());
    }

    @Test
    public void testDeleteNonExistentIdDoesNotAffectList() {
        Booking b1 = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        adapter.save(b1);

        adapter.delete("NON_EXISTENT");
        assertEquals(1, adapter.findAll().size());
    }

    @Test
    public void testReadFacultyUserTypeFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B300,R105,U500,10,12,faculty\n");
        }

        List<Booking> list = adapter.findAll();
        assertEquals(1, list.size());
        assertEquals("B300", list.get(0).getId());
    }

    @Test
    public void testReadStaffUserTypeFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B400,R106,U600,14,16,staff\n");
        }

        List<Booking> list = adapter.findAll();
        assertEquals(1, list.size());
        assertEquals("B400", list.get(0).getId());
    }

    @Test
    public void testReadPartnerUserTypeFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B500,R107,U700,15,17,partner\n");
        }

        List<Booking> list = adapter.findAll();
        assertEquals(1, list.size());
        assertEquals("B500", list.get(0).getId());
    }

    @Test(expected = IllegalStateException.class)
    public void testReadCorruptedFileThrowsException() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B600,R108,U800,NOT_A_NUMBER,17,student\n");
        }
        adapter.findAll();
    }
}
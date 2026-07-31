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

import scheduler.data.CsvBookingRepository;
import scheduler.model.Booking;
import scheduler.strategy.FacultyPricingStrategy;
import scheduler.strategy.PartnerPricingStrategy;
import scheduler.strategy.StaffPricingStrategy;
import scheduler.strategy.StudentPricingStrategy;

public class CsvBookingRepositoryTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File testCsvFile;
    private CsvBookingRepository repository;

    @Before
    public void setUp() throws IOException {
        testCsvFile = tempFolder.newFile("test_repo_bookings.csv");
        repository = new CsvBookingRepository(testCsvFile.getAbsolutePath());
    }

    @Test
    public void testLoadNonExistentFileReturnsEmptyList() {
        CsvBookingRepository repo = new CsvBookingRepository("non_existent_bookings_path.csv");
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    public void testSaveAndFindAll() {
        Booking booking = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        repository.save(booking);

        List<Booking> list = repository.findAll();
        assertEquals(1, list.size());
        assertEquals("B100", list.get(0).getId());
        assertEquals("R101", list.get(0).getRoomId());
        assertEquals("U101", list.get(0).getUserId());
    }

    @Test
    public void testSaveNullBookingDoesNothing() {
        repository.save(null);
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    public void testSaveUpdateExistingBooking() {
        Booking initial = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        repository.save(initial);

        Booking updated = new Booking("B100", "R101", "U101", 10, 12, new FacultyPricingStrategy());
        repository.save(updated);

        List<Booking> list = repository.findAll();
        assertEquals(1, list.size());
        assertEquals(10, list.get(0).getStartHour());
        assertEquals(12, list.get(0).getEndHour());
    }

    @Test
    public void testDeleteBooking() {
        Booking b1 = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        Booking b2 = new Booking("B200", "R102", "U102", 12, 14, new FacultyPricingStrategy());
        repository.save(b1);
        repository.save(b2);

        repository.delete("B100");
        List<Booking> list = repository.findAll();
        assertEquals(1, list.size());
        assertEquals("B200", list.get(0).getId());
    }

    @Test
    public void testDeleteNonExistentIdDoesNotAffectList() {
        Booking b1 = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        repository.save(b1);

        repository.delete("NON_EXISTENT_ID");
        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void testLoadFacultyUserTypeFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B300,R105,U500,10,12,faculty\n");
        }

        CsvBookingRepository repo = new CsvBookingRepository(testCsvFile.getAbsolutePath());
        List<Booking> list = repo.findAll();
        assertEquals(1, list.size());
        assertEquals("B300", list.get(0).getId());
    }

    @Test
    public void testLoadStaffUserTypeFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B400,R106,U600,14,16,staff\n");
        }

        CsvBookingRepository repo = new CsvBookingRepository(testCsvFile.getAbsolutePath());
        List<Booking> list = repo.findAll();
        assertEquals(1, list.size());
        assertEquals("B400", list.get(0).getId());
    }

    @Test
    public void testLoadPartnerUserTypeFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,roomId,userId,startHour,endHour,userType\n");
            writer.write("B500,R107,U700,15,17,partner\n");
        }

        CsvBookingRepository repo = new CsvBookingRepository(testCsvFile.getAbsolutePath());
        List<Booking> list = repo.findAll();
        assertEquals(1, list.size());
        assertEquals("B500", list.get(0).getId());
    }

    @Test
    public void testFindAllReturnsCopyOfCache() {
        Booking booking = new Booking("B100", "R101", "U101", 9, 11, new StudentPricingStrategy());
        repository.save(booking);

        List<Booking> copy1 = repository.findAll();
        copy1.clear();

        List<Booking> copy2 = repository.findAll();
        assertEquals(1, copy2.size());
    }

    @Test
    public void testSaveDifferentUserTypeRates() {
        Booking facultyBooking = new Booking("B600", "R108", "U800", 9, 11, new FacultyPricingStrategy());
        Booking staffBooking = new Booking("B700", "R109", "U900", 11, 13, new StaffPricingStrategy());
        Booking partnerBooking = new Booking("B800", "R110", "U999", 13, 15, new PartnerPricingStrategy());

        repository.save(facultyBooking);
        repository.save(staffBooking);
        repository.save(partnerBooking);

        assertEquals(3, repository.findAll().size());
    }
}
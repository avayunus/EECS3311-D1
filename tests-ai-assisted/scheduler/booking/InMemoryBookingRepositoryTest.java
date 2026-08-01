package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scheduler.data.InMemoryBookingRepository;
import scheduler.model.Booking;
import scheduler.strategy.PricingStrategy;

public class InMemoryBookingRepositoryTest {

    private InMemoryBookingRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryBookingRepository();
    }

    // --- STUB FOR PRICING STRATEGY REQUIRED BY BOOKING CONSTRUCTOR ---
    private static class StubPricingStrategy implements PricingStrategy {
        @Override public double getHourlyRate() { return 10.0; }
        @Override public double calculateCost(int hours) { return 10.0 * hours; }
    }

    // --- FIND ALL TESTS ---

    @Test
    public void testFindAll_returnsEmptyInitially() {
        List<Booking> results = repository.findAll();
        assertNotNull(results);
        assertTrue(results.isEmpty(), "Repository should be empty upon creation.");
    }

    @Test
    public void testFindAll_returnsDefensiveCopy() {
        Booking b = new Booking("id-1", "RoomA", "User1", 9, 10, new StubPricingStrategy());
        repository.save(b);

        List<Booking> snapshot1 = repository.findAll();
        List<Booking> snapshot2 = repository.findAll();

        // Verify it's a defensive copy allocation in memory
        assertNotSame(snapshot1, snapshot2, "findAll must return a brand new list reference pointer every call.");
        assertEquals(1, snapshot1.size());
        assertEquals(b, snapshot1.get(0));
    }

    // --- SAVE / UPSERT TESTS ---

    @Test
    public void testSave_insertsNewRecord() {
        Booking b = new Booking("id-new", "RoomB", "User2", 13, 14, new StubPricingStrategy());
        repository.save(b);

        List<Booking> results = repository.findAll();
        assertEquals(1, results.size());
        assertEquals(b, results.get(0));
    }

    @Test
    public void testSave_updatesExistingRecordWithoutDuplicates() {
        Booking initial = new Booking("id-unique", "RoomOld", "User3", 10, 11, new StubPricingStrategy());
        repository.save(initial);

        // Save a booking with the same ID but modified values
        Booking updated = new Booking("id-unique", "RoomNew", "User3", 15, 17, new StubPricingStrategy());
        repository.save(updated);

        List<Booking> current = repository.findAll();
        assertEquals(1, current.size(), "Saving a duplicate ID must replace the entry instead of expanding the list.");
        assertEquals("RoomNew", current.get(0).getRoomId());
        assertEquals(15, current.get(0).getStartHour());
    }

    // --- DELETE TESTS ---

    @Test
    public void testDelete_idExistsRemovesRecord() {
        Booking b1 = new Booking("keep-me", "Room1", "User1", 9, 10, new StubPricingStrategy());
        Booking b2 = new Booking("delete-me", "Room2", "User2", 11, 12, new StubPricingStrategy());

        repository.save(b1);
        repository.save(b2);

        // Executes the matching branch condition inside the delete loop
        repository.delete("delete-me");

        List<Booking> current = repository.findAll();
        assertEquals(1, current.size());
        assertEquals("keep-me", current.get(0).getId());
    }

    @Test
    public void testDelete_idDoesNotExistLeavesStateUntouched() {
        Booking b = new Booking("keep-me", "Room1", "User1", 9, 10, new StubPricingStrategy());
        repository.save(b);

        // Exhausts the loop bounds without ever hitting the inner match branch statement
        repository.delete("non-existent-id");

        List<Booking> current = repository.findAll();
        assertEquals(1, current.size());
        assertEquals("keep-me", current.get(0).getId());
    }
}
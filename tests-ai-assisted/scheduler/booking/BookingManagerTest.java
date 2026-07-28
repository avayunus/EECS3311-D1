package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scheduler.data.IBookingRepository;
import scheduler.model.Booking;
import scheduler.rules.IConflictRules;

public class BookingManagerTest {

    private BookingManager bookingManager;
    private FakeBookingRepository fakeRepo;
    private FakeConflictRules fakeRules;

    @BeforeEach
    public void setUp() throws Exception {
        // 1. Reset the Singleton instance via Reflection to ensure total test isolation
        Field instanceField = BookingManager.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);

        // 2. Initialize fresh fakes for every test case
        fakeRepo = new FakeBookingRepository();
        fakeRules = new FakeConflictRules();

        // 3. Grab the clean instance
        bookingManager = BookingManager.getInstance();
    }

    // --- HAND-WRITTEN FAKES & SPIES FOR TESTING ---

    public static class FakeConflictRules implements IConflictRules {
        public boolean allowedResult = true;

        @Override
        public boolean isAllowed(Booking b, List<Booking> current) {
            return allowedResult;
        }
    }

    public static class FakeBookingRepository implements IBookingRepository {
        public List<Booking> initialBookings = new ArrayList<>();
        public List<Booking> savedBookings = new ArrayList<>();
        public List<String> deletedIds = new ArrayList<>();

        @Override
        public List<Booking> findAll() {
            return initialBookings;
        }

        @Override
        public void save(Booking b) {
            savedBookings.add(b);
        }

        @Override
        public void delete(String id) {
            deletedIds.add(id);
        }
    }

    public static class SpyBookingObserver implements BookingObserver {
        public int notificationCount = 0;

        @Override
        public void onBookingsChanged() {
            notificationCount++;
        }
    }

    // --- SINGLETON & LIFECYCLE TESTS ---

    @Test
    public void testGetInstance_returnsSameInstance() {
        BookingManager secondInstance = BookingManager.getInstance();
        assertSame(bookingManager, secondInstance, "getInstance() must always return the exact same object reference.");
    }

    @Test
    public void testRequireInitialized_throwsException() {
        Booking dummyBooking = new Booking("dummy-id", "room1", "user1", 9, 10, null);

        assertThrows(IllegalStateException.class, () -> {
            bookingManager.addBooking(dummyBooking);
        }, "Should fail if addBooking is called before initialization.");

        assertThrows(IllegalStateException.class, () -> {
            bookingManager.cancelBooking("id-123");
        }, "Should fail if cancelBooking is called before initialization.");
    }

    @Test
    public void testInitialize_loadsBookingsAndNotifies() {
        Booking preExisting = new Booking("pre-existing-id", "room1", "user1", 9, 10, null);
        fakeRepo.initialBookings.add(preExisting);

        SpyBookingObserver spyObserver = new SpyBookingObserver();
        bookingManager.register(spyObserver);

        bookingManager.initialize(fakeRepo, fakeRules);

        assertEquals(1, bookingManager.getBookings().size(), "Initialization should pull existing data from the repo.");
        assertEquals(1, spyObserver.notificationCount, "Observer should be notified during initialization.");
    }

    // --- ADD BOOKING TESTS ---

    @Test
    public void testAddBooking_success() {
        bookingManager.initialize(fakeRepo, fakeRules);
        Booking freshBooking = new Booking("fresh-id", "room1", "user1", 10, 11, null);

        fakeRules.allowedResult = true;
        SpyBookingObserver spyObserver = new SpyBookingObserver();
        bookingManager.register(spyObserver);

        boolean result = bookingManager.addBooking(freshBooking);

        assertTrue(result);
        assertTrue(fakeRepo.savedBookings.contains(freshBooking), "Repo save should be called.");
        assertEquals(1, spyObserver.notificationCount, "Observers should be notified.");
        assertTrue(bookingManager.getBookings().contains(freshBooking));
    }

    @Test
    public void testAddBooking_clash() {
        bookingManager.initialize(fakeRepo, fakeRules);
        Booking clashingBooking = new Booking("clash-id", "room1", "user1", 10, 11, null);

        fakeRules.allowedResult = false;
        SpyBookingObserver spyObserver = new SpyBookingObserver();
        bookingManager.register(spyObserver);

        boolean result = bookingManager.addBooking(clashingBooking);

        assertFalse(result);
        assertTrue(fakeRepo.savedBookings.isEmpty(), "Repo save should never be called on clash.");
        assertEquals(0, spyObserver.notificationCount, "Observers should not be notified.");
    }

    @Test
    public void testAddBooking_nullBooking() {
        bookingManager.initialize(fakeRepo, fakeRules);

        boolean result = bookingManager.addBooking(null);

        assertFalse(result, "Adding a null booking must safely short-circuit and return false.");
    }

    // --- CANCEL BOOKING TESTS ---

    @Test
    public void testCancelBooking_success() {
        Booking target = new Booking("target-id", "room1", "user1", 12, 13, null);

        fakeRepo.initialBookings.add(target);
        bookingManager.initialize(fakeRepo, fakeRules);

        SpyBookingObserver spyObserver = new SpyBookingObserver();
        bookingManager.register(spyObserver);

        boolean result = bookingManager.cancelBooking("target-id");

        assertTrue(result);
        assertTrue(fakeRepo.deletedIds.contains("target-id"), "Repo delete should be tracked.");
        assertEquals(1, spyObserver.notificationCount, "Observers should be notified.");
        assertNull(bookingManager.findById("target-id"));
    }

    @Test
    public void testCancelBooking_notFound() {
        bookingManager.initialize(fakeRepo, fakeRules);

        SpyBookingObserver spyObserver = new SpyBookingObserver();
        bookingManager.register(spyObserver);

        boolean result = bookingManager.cancelBooking("non-existent-id");

        assertFalse(result);
        assertTrue(fakeRepo.deletedIds.isEmpty(), "Repo delete should not be called.");
        assertEquals(0, spyObserver.notificationCount, "Observers should not be notified.");
    }

    // --- LOOKUPS & ENCAPSULATION TESTS ---

    @Test
    public void testGetBookings_returnsDefensiveCopy() {
        bookingManager.initialize(fakeRepo, fakeRules);
        List<Booking> snapshot1 = bookingManager.getBookings();

        List<Booking> snapshot2 = bookingManager.getBookings();
        assertNotSame(snapshot1, snapshot2, "Every call to getBookings() must spin up a fresh list memory allocation.");
    }

    @Test
    public void testFindById_successAndNull() {
        Booking expected = new Booking("real-id", "room1", "user1", 14, 15, null);

        fakeRepo.initialBookings.add(expected);
        bookingManager.initialize(fakeRepo, fakeRules);

        assertEquals(expected, bookingManager.findById("real-id"));
        assertNull(bookingManager.findById("fake-id"));
    }

    // --- OBSERVER TESTS ---

    @Test
    public void testRegister_nullAndDuplicates() {
        bookingManager.initialize(fakeRepo, fakeRules);
        SpyBookingObserver spyObserver = new SpyBookingObserver();

        // Register duplicate and null
        bookingManager.register(spyObserver);
        bookingManager.register(spyObserver);
        bookingManager.register(null);

        // Trigger action that notifies
        Booking b = new Booking("notify-id", "room1", "user1", 16, 17, null);
        fakeRules.allowedResult = true;
        bookingManager.addBooking(b);

        assertEquals(1, spyObserver.notificationCount, "Observer should only be notified once despite multiple registrations.");
    }

    @Test
    public void testUnregister_success() {
        bookingManager.initialize(fakeRepo, fakeRules);
        SpyBookingObserver spyObserver = new SpyBookingObserver();

        bookingManager.register(spyObserver);
        bookingManager.unregister(spyObserver);

        Booking b = new Booking("unreg-id", "room1", "user1", 18, 19, null);
        fakeRules.allowedResult = true;
        bookingManager.addBooking(b);

        assertEquals(0, spyObserver.notificationCount, "Unregistered observer should not receive callbacks.");
    }

    @Test
    public void testNotifyObservers_avoidsConcurrentModification() {
        bookingManager.initialize(fakeRepo, fakeRules);

        // A dynamic self-destructing spy to verify concurrent modification safety
        BookingObserver selfDestructingObserver = new BookingObserver() {
            @Override
            public void onBookingsChanged() {
                bookingManager.unregister(this);
            }
        };

        bookingManager.register(selfDestructingObserver);

        assertDoesNotThrow(() -> {
            bookingManager.notifyObservers();
        }, "Should handle dynamic observer unregistration mid-loop without crashes.");
    }
}
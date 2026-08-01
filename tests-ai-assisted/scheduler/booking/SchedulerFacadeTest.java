package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scheduler.booking.BookingManager;
import scheduler.booking.BookingObserver;
import scheduler.data.IBookingRepository;
import scheduler.data.IRoomRepository;
import scheduler.data.IUserRepository;
import scheduler.facade.SchedulerFacade;
import scheduler.model.Booking;
import scheduler.model.Room;
import scheduler.model.TimeSlot;
import scheduler.model.User;
import scheduler.rules.IConflictRules;
import scheduler.strategy.PricingStrategy;

public class SchedulerFacadeTest {

    private SchedulerFacade facade;
    private FakeRoomRepository fakeRoomRepo;
    private FakeUserRepository fakeUserRepo;
    private FakeBookingRepository fakeBookingRepo;
    private FakeConflictRules fakeRules;

    @BeforeEach
    public void setUp() throws Exception {
        // 1. Reset the BookingManager Singleton state via reflection for test isolation
        Field instanceField = BookingManager.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);

        // 2. Initialize fresh test fakes
        fakeRoomRepo = new FakeRoomRepository();
        fakeUserRepo = new FakeUserRepository();
        fakeBookingRepo = new FakeBookingRepository();
        fakeRules = new FakeConflictRules();

        // 3. Instantiate the facade and bootstrap the BookingManager engine
        facade = new SchedulerFacade(fakeRoomRepo, fakeUserRepo);
        facade.start(fakeBookingRepo, fakeRules);
    }

    // --- HAND-WRITTEN TEST FAKES & SPIES ---

    private static class StubPricingStrategy implements PricingStrategy {
        @Override public double getHourlyRate() { return 10.0; }
        @Override public double calculateCost(int hours) { return 10.0 * hours; }
    }

    private static class FakeConflictRules implements IConflictRules {
        public boolean allowedResult = true;
        @Override
        public boolean isAllowed(Booking b, List<Booking> current) { return allowedResult; }
    }

    private static class FakeBookingRepository implements IBookingRepository {
        public List<Booking> bookings = new ArrayList<>();
        @Override public List<Booking> findAll() { return bookings; }
        @Override public void save(Booking b) { bookings.add(b); }
        @Override public void delete(String id) { bookings.removeIf(b -> b.getId().equals(id)); }
    }

    private static class FakeRoomRepository implements IRoomRepository {
        public List<Room> rooms = new ArrayList<>();
        @Override public List<Room> findAll() { return rooms; }
        @Override
        public Room findById(String id) {
            for (Room r : rooms) { if (r.getId().equals(id)) return r; }
            return null;
        }
        @Override public void save(Room room) {}
    }

    private static class FakeUserRepository implements IUserRepository {
        public List<User> users = new ArrayList<>();
        @Override public List<User> findAll() { return users; }
        @Override
        public User findById(String id) {
            for (User u : users) { if (u.getId().equals(id)) return u; }
            return null;
        }
        @Override
        public User findByEmail(String email) {
            for (User u : users) { if (u.getEmail().equalsIgnoreCase(email)) return u; }
            return null;
        }
        @Override public void save(User user) {}
    }

    private static class SpyBookingObserver implements BookingObserver {
        public int count = 0;
        @Override public void onBookingsChanged() { count++; }
    }

    // --- SERVICE BOOTSTRAPPER TESTS ---

    @Test
    public void testStart_initializesBookingManager() {
        Booking preExisting = new Booking("b-pre", "room1", "user1", 9, 10, new StubPricingStrategy());
        fakeBookingRepo.bookings.add(preExisting);

        // Triggering start should re-initialize underlying booking collections
        facade.start(fakeBookingRepo, fakeRules);
        assertEquals(1, facade.getBookings().size());
        assertEquals(preExisting, facade.getBookings().get(0));
    }

    // --- BOOKING REQUEST BRANCH TESTS ---

    @Test
    public void testRequestBooking_invalidInputsReturnFalse() {
        Room validRoom = new Room("r1", "Room 1", 30, "Building A", "AVAILABLE");
        TimeSlot validSlot = new TimeSlot(9, 10);
        PricingStrategy strategy = new StubPricingStrategy();

        // Cast the first argument explicitly to resolve the compiler ambiguity
        assertFalse(facade.requestBooking((Room) null, validSlot, "u1", strategy),
                "Should return false if Room object is null");

        assertFalse(facade.requestBooking((String) null, validSlot, "u1", strategy),
                "Should return false if Room ID string is null");

        // The remaining assertions don't suffer from ambiguity
        assertFalse(facade.requestBooking(validRoom, null, "u1", strategy),
                "Should return false if TimeSlot is null");

        assertFalse(facade.requestBooking(validRoom, validSlot, null, strategy),
                "Should return false if User ID is null");

        assertFalse(facade.requestBooking(validRoom, validSlot, "   ", strategy),
                "Should return false if User ID is blank");
    }

    @Test
    public void testRequestBooking_unknownOrNonBookableRoomReturnsFalse() {
        Room unbookableRoom = new Room("r-maintenance", "Room 2", 30, "Building A", "MAINTENANCE");
        fakeRoomRepo.rooms.add(unbookableRoom);

        TimeSlot slot = new TimeSlot(9, 10);
        PricingStrategy strategy = new StubPricingStrategy();

        // Case 1: Room isn't managed by repository
        Room unknownRoom = new Room("r-unknown", "Ghost Room", 10, "B", "AVAILABLE");
        assertFalse(facade.requestBooking(unknownRoom, slot, "u1", strategy));

        // Case 2: Room exists but is not bookable
        assertFalse(facade.requestBooking(unbookableRoom, slot, "u1", strategy));
    }

    @Test
    public void testRequestBooking_successfulFlow() {
        Room bookableRoom = new Room("r-good", "Room Good", 50, "Building A", "AVAILABLE");
        fakeRoomRepo.rooms.add(bookableRoom);

        TimeSlot slot = new TimeSlot(13, 14);
        PricingStrategy strategy = new StubPricingStrategy();

        boolean result = facade.requestBooking(bookableRoom, slot, "user-ok", strategy);

        assertTrue(result);
        assertEquals(1, facade.getBookings().size());
        assertEquals("user-ok", facade.getBookings().get(0).getUserId());
    }

    @Test
    public void testRequestBooking_clashReturnsFalse() {
        Room bookableRoom = new Room("r-good", "Room Good", 50, "Building A", "AVAILABLE");
        fakeRoomRepo.rooms.add(bookableRoom);

        // Set rule engine to decline all insertions
        fakeRules.allowedResult = false;

        boolean result = facade.requestBooking(bookableRoom, new TimeSlot(9, 10), "u1", new StubPricingStrategy());
        assertFalse(result);
        assertTrue(facade.getBookings().isEmpty());
    }

    @Test
    public void testRequestBookingConvenienceOverload_successAndFailure() {
        Room bookableRoom = new Room("r-id", "Room ID", 50, "Building A", "AVAILABLE");
        fakeRoomRepo.rooms.add(bookableRoom);

        TimeSlot slot = new TimeSlot(10, 11);
        PricingStrategy strategy = new StubPricingStrategy();

        // Valid path passing String identifier
        assertTrue(facade.requestBooking("r-id", slot, "u1", strategy));

        // Invalid path passing missing String identifier
        assertFalse(facade.requestBooking("r-fake", slot, "u1", strategy));
    }

    // --- TRANSACTION AND PASSTHROUGH WRAPPER TESTS ---

    @Test
    public void testCancelBooking_delegatesToBookingManager() {
        Room room = new Room("r1", "Room 1", 30, "Building A", "AVAILABLE");
        fakeRoomRepo.rooms.add(room);
        facade.requestBooking(room, new TimeSlot(9, 10), "u1", new StubPricingStrategy());

        String generatedId = facade.getBookings().get(0).getId();

        // Valid execution path
        assertTrue(facade.cancelBooking(generatedId));
        assertTrue(facade.getBookings().isEmpty());

        // Missing validation path
        assertFalse(facade.cancelBooking("fake-booking-id"));
    }

    @Test
    public void testFindBooking_returnsCorrectInstance() {
        Room room = new Room("r1", "Room 1", 30, "Building A", "AVAILABLE");
        fakeRoomRepo.rooms.add(room);
        facade.requestBooking(room, new TimeSlot(9, 10), "u1", new StubPricingStrategy());

        Booking created = facade.getBookings().get(0);
        assertEquals(created, facade.findBooking(created.getId()));
        assertNull(facade.findBooking("b-missing"));
    }

    @Test
    public void testRoomPassThroughs() {
        Room r1 = new Room("r1", "Name 1", 10, "B1", "AVAILABLE");
        Room r2 = new Room("r2", "Name 2", 20, "B2", "OCCUPIED");
        fakeRoomRepo.rooms.addAll(Arrays.asList(r1, r2));

        assertEquals(2, facade.getRooms().size());
        assertEquals(r1, facade.findRoom("r1"));
        assertNull(facade.findRoom("r-missing"));
    }

    @Test
    public void testUserPassThroughs() {
        User u1 = new User("u1", "u1@yorku.ca", "p1", "student", "id1", true);
        User u2 = new User("u2", "U2@YORKU.CA", "p2", "faculty", "id2", true);
        fakeUserRepo.users.addAll(Arrays.asList(u1, u2));

        assertEquals(2, facade.getUsers().size());
        assertEquals(u1, facade.findUser("u1"));
        assertNull(facade.findUser("u-missing"));

        // Case-insensitive check
        assertEquals(u2, facade.findUserByEmail("u2@yorku.ca"));
        assertNull(facade.findUserByEmail("missing@yorku.ca"));
    }

    @Test
    public void testObserverManagementPassThroughs() {
        Room room = new Room("r1", "Room 1", 30, "Building A", "AVAILABLE");
        fakeRoomRepo.rooms.add(room);

        SpyBookingObserver spy = new SpyBookingObserver();

        facade.registerObserver(spy);
        facade.requestBooking(room, new TimeSlot(9, 10), "u1", new StubPricingStrategy());
        assertEquals(1, spy.count, "Registered observer should capture notification updates.");

        facade.unregisterObserver(spy);
        facade.requestBooking(room, new TimeSlot(11, 12), "u1", new StubPricingStrategy());
        assertEquals(1, spy.count, "Unregistered observer should no longer capture updates.");
    }
}
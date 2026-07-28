package scheduler.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import scheduler.booking.BookingManager;
import scheduler.booking.BookingObserver;
import scheduler.data.InMemoryBookingRepository;
import scheduler.model.Booking;
import scheduler.rules.NoOverlapRule;

public class bookingmanagertest {

    private BookingManager manager;

    @Before
    public void setUp() {
        manager = BookingManager.getInstance();
        manager.initialize(new InMemoryBookingRepository(), new NoOverlapRule());
    }

    // helper
    // check  observer stuff actually works
    private static class CountingObserver implements BookingObserver {
        int count = 0;

        public void onBookingsChanged() {
            count++;
        }
    }


    @Test
    public void singletonReturnsSameObject() {
           assertSame(manager, BookingManager.getInstance());
    }


    @Test
    public void addBookingSucceedsWhenRoomIsFree() {
        Booking b = new Booking("b1", "LAS1004", "ayunus", 9, 10, null);
        assertTrue(manager.addBooking(b));
        assertEquals(1, manager.getBookings().size());
    }

    @Test
    public void addBookingRejectsOverlapInSameRoom() {
        // first one 
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 11, null));
        // second 
        Booking clash = new Booking("b2", "LAS1004", "trobel", 10, 12, null);
        assertFalse(manager.addBooking(clash));
        // and not added
        assertEquals(1, manager.getBookings().size());
    }

    @Test
    public void addBookingAllowsSameTimeInDifferentRoom() {
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 11, null));
        Booking other = new Booking("b2", "LAS2005", "trobel", 9, 11, null);
        assertTrue(manager.addBooking(other));
        assertEquals(2, manager.getBookings().size());
    }

    @Test
    public void addBookingRejectsNull() {
        assertFalse(manager.addBooking(null));
    }


    @Test
    public void cancelRemovesExistingBooking() {
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 10, null));
        assertTrue(manager.cancelBooking("b1"));
        // after cancelling, looking it up should give nothing back
        assertNull(manager.findById("b1"));
    }

    @Test
    public void cancelReturnsFalseWhenIdNotFound() {
        // nothing with this id exist caller needs to know nothing happened
        assertFalse(manager.cancelBooking("does-not-exist"));
    }


    @Test
    public void getBookingsReturnsACopyNotTheRealList() {
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 10, null));
        List<Booking> copy = manager.getBookings();
        // managers list sould not change
        copy.clear();
        assertEquals(1, manager.getBookings().size());
    }

    @Test
    public void findByIdFindsItOrReturnsNull() {
        Booking b = new Booking("real", "LAS1004", "ayunus", 9, 10, null);
        manager.addBooking(b);
        assertEquals(b, manager.findById("real"));
        assertNull(manager.findById("fake"));
    }

    @Test
    public void initializeLoadsBookingsFromRepo() {
        // put a booking in the repo  initialize 
        InMemoryBookingRepository seeded = new InMemoryBookingRepository();
        seeded.save(new Booking("old1", "LAS1003", "asabu", 8, 9, null));
        manager.initialize(seeded, new NoOverlapRule());
        assertEquals(1, manager.getBookings().size());
        assertNotNull(manager.findById("old1"));
    }


    @Test
    public void observerGetsNotifiedWhenBookingAdded() {
        // fresh observer 
        CountingObserver obs = new CountingObserver();
        manager.register(obs);
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 10, null));
        assertEquals(1, obs.count);
    }

    @Test
    public void unregisteredObserverStopsGettingNotified() {
        CountingObserver obs = new CountingObserver();
        manager.register(obs);
        manager.unregister(obs);
        // it left, so this add shoudnt reach it
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 10, null));
        assertEquals(0, obs.count);
    }

    @Test
    public void registeringSameObserverTwiceOnlyNotifiesOnce() {
        CountingObserver obs = new CountingObserver();
        manager.register(obs);
        manager.register(obs); // duplicate, should be ignored
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 10, null));
        assertEquals(1, obs.count);
    }

    @Test
    public void registeringNullObserverIsIgnored() {
        //  null shouldnt crash the notify loop later
        manager.register(null);
        CountingObserver obs = new CountingObserver();
        manager.register(obs);
        manager.addBooking(new Booking("b1", "LAS1004", "ayunus", 9, 10, null));
        assertEquals(1, obs.count);
    }
}
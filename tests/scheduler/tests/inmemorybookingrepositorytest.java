package scheduler.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import scheduler.data.InMemoryBookingRepository;
import scheduler.model.Booking;

public class inmemorybookingrepositorytest {

     private InMemoryBookingRepository repo;

    @Before
    public void setUp() {
        repo = new InMemoryBookingRepository();
    }

     // helper so i dont retype the booking every time, pricing doesnt matter here
    private Booking make(String id, String room) {
        return new Booking(id, room, "someuser", 9, 10, null);
      }

    @Test
    public void newRepoIsEmpty() {
        // nothing saved yet
        assertEquals(0, repo.findAll().size());
    }

    @Test
    public void saveAddsABooking() {
        repo.save(make("b1", "LAS1004"));
        assertEquals(1, repo.findAll().size());
    }

    @Test
    public void saveTwoDifferentBookings() {
        repo.save(make("b1", "LAS1004"));
        repo.save(make("b2", "LAS2005"));
        assertEquals(2, repo.findAll().size());
    }

    @Test
    public void findAllReturnsACopy() {
        repo.save(make("b1", "LAS1004"));
        List<Booking> list = repo.findAll();
        // messing with the returned list shouldnt change whats in the repo
         list.clear();
        assertEquals(1, repo.findAll().size());
    }

    @Test
    public void savingSameIdReplacesTheOldOne() {
        // save deletes the old one with that id first, so its like an update
        repo.save(make("b1", "LAS1004"));
        repo.save(make("b1", "LAS2005"));
        assertEquals(1, repo.findAll().size());
        // and the room should be the new one
        assertEquals("LAS2005", repo.findAll().get(0).getRoomId());
    }

    @Test
    public void deleteRemovesTheBooking() {
        repo.save(make("b1", "LAS1004"));
        repo.delete("b1");
        assertEquals(0, repo.findAll().size());
    }

    @Test
    public void deleteOnlyRemovesTheMatchingOne() {
        repo.save(make("b1", "LAS1004"));
        repo.save(make("b2", "LAS2005"));
        repo.delete("b1");
        assertEquals(1, repo.findAll().size());
        // b2 should still be there
        assertEquals("b2", repo.findAll().get(0).getId());
    }

    @Test
    public void deleteMissingIdDoesNothing() {
         repo.save(make("b1", "LAS1004"));
        // theres no b99 so this should just do nothing and not crash
        repo.delete("b99");
        assertEquals(1, repo.findAll().size());
    }

    @Test
    public void deleteOnEmptyRepoIsFine() {
        // shouldnt blow up even with nothing in there
        repo.delete("b1");
        assertEquals(0, repo.findAll().size());
    }

    @Test
    public void saveThenFindContainsTheRightBooking() {
        Booking b = make("b1", "LAS1004");
        repo.save(b);
        assertEquals(b, repo.findAll().get(0));
    }

    @Test
    public void saveDeleteSaveAgainWorks() {
        repo.save(make("b1", "LAS1004"));
        repo.delete("b1");
        repo.save(make("b1", "LAS1004"));
        assertEquals(1, repo.findAll().size());
    }
}
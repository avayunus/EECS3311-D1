package scheduler.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import scheduler.model.Booking;
import scheduler.rules.NoOverlapRule;

public class nooverlapruletest {

    private NoOverlapRule rule;

    @Before
    public void setUp() {
        rule = new NoOverlapRule();
    }

    // helper
    // pricing doesnt matter here so i just pass null
    private Booking make(String id, String room, int start, int end) {
        return new Booking(id, room, "someuser", start, end, null);
    }

    @Test
    public void emptyListIsAllowed() {
        // nothing booked yet so anything is fine
        Booking candidate = make("b1", "LAS1004", 9, 10);
        assertTrue(rule.isAllowed(candidate, new ArrayList<Booking>()));
    }

    @Test
    public void noOverlapSameRoomIsAllowed() {
        // existing is 9 to 10, new one is 11 to 12, big gap so ok
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 9, 10));
        Booking candidate = make("b2", "LAS1004", 11, 12);
        assertTrue(rule.isAllowed(candidate, existing));
    }

    @Test
    public void overlapSameRoomIsNotAllowed() {
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 9, 11));
        Booking candidate = make("b2", "LAS1004", 10, 12);
        assertFalse(rule.isAllowed(candidate, existing));
    }

    @Test
    public void sameTimeDifferentRoomIsAllowed() {
        // same hours but different room so the rule shouldnt care
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 9, 11));
        Booking candidate = make("b2", "LAS2005", 9, 11);
        assertTrue(rule.isAllowed(candidate, existing));
    }

    @Test
    public void touchingAtTheEndIsAllowed() {
        // existing ends and new one starts
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 9, 10));
        Booking candidate = make("b2", "LAS1004", 10, 11);
        assertTrue(rule.isAllowed(candidate, existing));
    }

    @Test
    public void touchingAtTheStartIsAllowed() {
        // new one ends right when the existing one starts
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 10, 11));
        Booking candidate = make("b2", "LAS1004", 9, 10);
        assertTrue(rule.isAllowed(candidate, existing));
    }

    @Test
    public void candidateInsideExistingIsNotAllowed() {
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 8, 12));
        Booking candidate = make("b2", "LAS1004", 9, 10);
        assertFalse(rule.isAllowed(candidate, existing));
    }

    @Test
    public void existingInsideCandidateIsNotAllowed() {
        // other way around
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 9, 10));
        Booking candidate = make("b2", "LAS1004", 8, 12);
        assertFalse(rule.isAllowed(candidate, existing));
    }

    @Test
    public void exactSameTimeSameRoomIsNotAllowed() {
        // literally the same slot in the same room
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 9, 11));
        Booking candidate = make("b2", "LAS1004", 9, 11);
        assertFalse(rule.isAllowed(candidate, existing));
    }

    @Test
    public void clashesWithOneOfManyIsNotAllowed() {
        // a few existing bookings and the new one clashes with the middle one
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 8, 9));
        existing.add(make("b2", "LAS1004", 12, 13));
        existing.add(make("b3", "LAS2005", 9, 11));
        Booking candidate = make("b4", "LAS1004", 8, 10);
        assertFalse(rule.isAllowed(candidate, existing));
    }

    @Test
    public void fitsAroundManyIsAllowed() {
        // lots booked but the new one slots into a free gap
        List<Booking> existing = new ArrayList<Booking>();
        existing.add(make("b1", "LAS1004", 8, 9));
        existing.add(make("b2", "LAS1004", 12, 13));
        existing.add(make("b3", "LAS2005", 9, 11));
        Booking candidate = make("b4", "LAS1004", 9, 11);
        assertTrue(rule.isAllowed(candidate, existing));
    }
}
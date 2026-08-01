package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import scheduler.model.Booking;
import scheduler.rules.NoOverlapRule;
import scheduler.strategy.PricingStrategy;

public class NoOverlapRuleTest {

    private NoOverlapRule rule;

    @BeforeEach
    public void setUp() {
        rule = new NoOverlapRule();
    }

    // --- HAND-WRITTEN STUB FOR PRICING STRATEGY ---
    private static class StubPricingStrategy implements PricingStrategy {
        @Override public double getHourlyRate() { return 10.0; }
        @Override public double calculateCost(int hours) { return 10.0 * hours; }
    }

    // --- RULE ANALYSIS TEST CASES ---

    @Test
    public void testIsAllowed_trueWhenExistingListIsEmpty() {
        Booking candidate = new Booking("c1", "room-A", "user1", 9, 11, new StubPricingStrategy());
        List<Booking> existing = new ArrayList<>();

        // Evaluates cleanly to true without entering loop iterations
        assertTrue(rule.isAllowed(candidate, existing),
                "Candidate booking should be allowed if there are no current existing bookings.");
    }

    @Test
    public void testIsAllowed_trueWhenRoomsAreDifferent() {
        Booking existingBooking = new Booking("e1", "room-A", "user2", 9, 12, new StubPricingStrategy());
        Booking candidate = new Booking("c1", "room-B", "user1", 10, 11, new StubPricingStrategy());

        List<Booking> existing = Arrays.asList(existingBooking);

        // Triggers the inner loop "!b.getRoomId().equals(...)" branch -> continue
        assertTrue(rule.isAllowed(candidate, existing),
                "Candidate booking should be allowed if the time conflict resides in a completely different room.");
    }

    @Test
    public void testIsAllowed_falseWhenStrictOverlapExistsInSameRoom() {
        // Existing booking spans 13:00 to 16:00
        Booking existingBooking = new Booking("e1", "room-A", "user2", 13, 16, new StubPricingStrategy());

        // Candidate booking spans 14:00 to 15:00 (completely inside)
        Booking candidate = new Booking("c1", "room-A", "user1", 14, 15, new StubPricingStrategy());

        List<Booking> existing = Arrays.asList(existingBooking);

        // Triggers "overlaps = true" -> returns false early
        assertFalse(rule.isAllowed(candidate, existing),
                "Should deny booking if candidate window falls completely inside an existing reservation.");
    }

    @Test
    public void testIsAllowed_trueWhenBookingsArePerfectlyAdjacent() {
        // Existing booking spans 09:00 to 11:00
        Booking existingBooking = new Booking("e1", "room-A", "user2", 9, 11, new StubPricingStrategy());

        // Candidate 1: Ends exactly when the existing booking starts (07:00 to 09:00)
        Booking candidateBefore = new Booking("c1", "room-A", "user1", 7, 9, new StubPricingStrategy());

        // Candidate 2: Starts exactly when the existing booking ends (11:00 to 13:00)
        Booking candidateAfter = new Booking("c2", "room-A", "user3", 11, 13, new StubPricingStrategy());

        List<Booking> existing = Arrays.asList(existingBooking);

        // Verifies boundary logic inequality evaluations (startHour < endHour expressions)
        assertTrue(rule.isAllowed(candidateBefore, existing),
                "Adjacent back-to-back bookings should be permitted if candidate ends exactly when existing starts.");
        assertTrue(rule.isAllowed(candidateAfter, existing),
                "Adjacent back-to-back bookings should be permitted if candidate starts exactly when existing ends.");
    }

    @Test
    public void testIsAllowed_falseWhenPartialOverlapExistsAtStartOrEnd() {
        Booking existingBooking = new Booking("e1", "room-A", "user2", 10, 12, new StubPricingStrategy());

        // Candidate 1: Overlaps existing booking's start (09:00 to 11:00)
        Booking candidateLeft = new Booking("c1", "room-A", "user1", 9, 11, new StubPricingStrategy());

        // Candidate 2: Overlaps existing booking's end (11:00 to 13:00)
        Booking candidateRight = new Booking("c2", "room-A", "user3", 11, 13, new StubPricingStrategy());

        List<Booking> existing = Arrays.asList(existingBooking);

        assertFalse(rule.isAllowed(candidateLeft, existing), "Should deny booking if candidate tail bleeds into existing start window.");
        assertFalse(rule.isAllowed(candidateRight, existing), "Should deny booking if candidate start bleeds into existing tail window.");
    }
}
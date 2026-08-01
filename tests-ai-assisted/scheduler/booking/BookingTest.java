package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scheduler.model.Booking;
import scheduler.strategy.PricingStrategy;

public class BookingTest {

    private StubPricingStrategy initialStrategy;

    @BeforeEach
    public void setUp() {
        // A base strategy setup: $20.0 per hour
        initialStrategy = new StubPricingStrategy(20.0);
    }

    // --- HAND-WRITTEN STUB FOR PRICING STRATEGY ---
    private static class StubPricingStrategy implements PricingStrategy {
        private final double rate;

        public StubPricingStrategy(double rate) {
            this.rate = rate;
        }

        @Override
        public double getHourlyRate() {
            return this.rate;
        }

        @Override
        public double calculateCost(int hours) {
            return this.rate * hours;
        }
    }

    // --- CONSTRUCTOR & GETTER VALIDATION TESTS ---

    @Test
    public void testBookingConstructorAndGetters_createsRightObject() {
        Booking booking = new Booking("b-001", "room-101", "user-42", 9, 12, initialStrategy);

        // Verify all primitive and object state mappings match constructor inputs
        assertNotNull(booking, "Booking object instantiation should succeed.");
        assertEquals("b-001", booking.getId());
        assertEquals("room-101", booking.getRoomId());
        assertEquals("user-42", booking.getUserId());
        assertEquals(9, booking.getStartHour());
        assertEquals(12, booking.getEndHour());
        assertSame(initialStrategy, booking.getPricingStrategy(), "Should store the correct pricing strategy reference.");
    }

    // --- STRATEGY & CALCULATION TESTS ---

    @Test
    public void testCalculateTotalCost_delegatesCorrectlyToStrategy() {
        // 13:00 to 17:00 = 4 hours. 4 hours * $20.0 = $80.0
        Booking booking = new Booking("b-002", "room-202", "user-11", 13, 17, initialStrategy);

        double expectedCost = 80.0;
        assertEquals(expectedCost, booking.calculateTotalCost(), 0.001, "Total cost should equal (endHour - startHour) * rate.");
    }

    @Test
    public void testGetUpfrontDeposit_returnsHourlyRate() {
        Booking booking = new Booking("b-003", "room-303", "user-22", 10, 11, initialStrategy);

        assertEquals(20.0, booking.getUpfrontDeposit(), 0.001, "Upfront deposit must pull directly from the hourly rate.");
    }

    // --- MUTATOR & TEXT SERIALIZATION TESTS ---

    @Test
    public void testSetPricingStrategy_updatesStrategyInstance() {
        Booking booking = new Booking("b-004", "room-404", "user-33", 9, 10, initialStrategy);

        // Swap to a premium strategy: $50.0 per hour
        StubPricingStrategy premiumStrategy = new StubPricingStrategy(50.0);
        booking.setPricingStrategy(premiumStrategy);

        assertSame(premiumStrategy, booking.getPricingStrategy(), "Strategy reference should be updated.");
        assertEquals(50.0, booking.calculateTotalCost(), 0.001, "Calculated cost should reflect the newly applied strategy.");
    }

    @Test
    public void testToString_formatsExpectedStringRepresentation() {
        Booking booking = new Booking("b-999", "hall-A", "user-admin", 14, 16, initialStrategy);

        String expectedString = "Booking[b-999 room=hall-A user=user-admin 14-16]";
        assertEquals(expectedString, booking.toString(), "toString format must match the exact pattern requirement.");
    }
}
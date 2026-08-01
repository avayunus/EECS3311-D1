package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import scheduler.model.Booking;
import scheduler.model.BookingFactory;
import scheduler.strategy.PricingStrategy;

public class BookingFactoryTest {

    // --- HAND-WRITTEN STUB FOR PRICING STRATEGY ---
    private static class StubPricingStrategy implements PricingStrategy {
        @Override
        public double getHourlyRate() {
            return 10.0;
        }

        @Override
        public double calculateCost(int hours) {
            return 10.0 * hours;
        }
    }

    // --- FACTORY METHOD TESTS ---

    @Test
    public void testCreateBooking_generatesIdAutomatically() {
        PricingStrategy strategy = new StubPricingStrategy();

        // Call the overload that generates a UUID
        Booking booking = BookingFactory.createBooking("room-101", "user-42", 9, 11, strategy);

        // Verify the object was created
        assertNotNull(booking, "Factory should instantiate a new Booking object.");

        // Verify the UUID generation rules ("b-" prefix + 8 UUID chars = 10 chars total)
        assertNotNull(booking.getId(), "Generated ID should not be null.");
        assertTrue(booking.getId().startsWith("b-"), "Generated ID must start with the 'b-' prefix.");
        assertEquals(10, booking.getId().length(), "Generated ID length must be exactly 10 characters.");

        // Verify field mapping
        assertEquals("room-101", booking.getRoomId());
        assertEquals("user-42", booking.getUserId());
        assertEquals(9, booking.getStartHour());
        assertEquals(11, booking.getEndHour());
        assertSame(strategy, booking.getPricingStrategy(), "Pricing strategy reference must remain intact.");
    }

    @Test
    public void testCreateBooking_usesProvidedId() {
        PricingStrategy strategy = new StubPricingStrategy();

        // Call the overload that accepts an explicit ID
        Booking booking = BookingFactory.createBooking("custom-id-999", "room-202", "user-55", 14, 16, strategy);

        // Verify the object was created
        assertNotNull(booking, "Factory should instantiate a new Booking object.");

        // Verify the exact ID was retained
        assertEquals("custom-id-999", booking.getId(), "Factory must use the explicitly provided ID.");

        // Verify field mapping
        assertEquals("room-202", booking.getRoomId());
        assertEquals("user-55", booking.getUserId());
        assertEquals(14, booking.getStartHour());
        assertEquals(16, booking.getEndHour());
        assertSame(strategy, booking.getPricingStrategy(), "Pricing strategy reference must remain intact.");
    }

    @Test
    public void testConstructor_implicitInstantiation() {
        // Factory classes often only have static methods, but coverage tools (like JaCoCo)
        // will flag the implicit default constructor as "uncovered" unless instantiated.
        BookingFactory factory = new BookingFactory();
        assertNotNull(factory);
    }
}
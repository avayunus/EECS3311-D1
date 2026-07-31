package scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import scheduler.model.Booking;
import scheduler.strategy.StudentPricingStrategy;
import scheduler.strategy.FacultyPricingStrategy;
import scheduler.strategy.PricingStrategy;

public class BookingTest {

    @Test
    public void testBookingCreationAndGetters() {
        PricingStrategy strategy = new StudentPricingStrategy();
        Booking booking = new Booking("B001", "R101", "U101", 9, 11, strategy);
        
        assertNotNull(booking);
        assertEquals("B001", booking.getId());
        assertEquals("R101", booking.getRoomId());
        assertEquals("U101", booking.getUserId());
        assertEquals(9, booking.getStartHour());
        assertEquals(11, booking.getEndHour());
    }

    @Test
    public void testCalculateTotalCost() {
        PricingStrategy strategy = new StudentPricingStrategy();
        Booking booking = new Booking("B002", "R102", "U101", 10, 13, strategy); // 3 hours
        double expectedCost = strategy.calculateCost(3);
        
        assertEquals(expectedCost, booking.calculateTotalCost(), 0.001);
    }

    @Test
    public void testGetUpfrontDeposit() {
        PricingStrategy strategy = new StudentPricingStrategy();
        Booking booking = new Booking("B003", "R101", "U101", 9, 10, strategy);
        
        assertEquals(strategy.getHourlyRate(), booking.getUpfrontDeposit(), 0.001);
    }

    @Test
    public void testSetPricingStrategy() {
        PricingStrategy initialStrategy = new StudentPricingStrategy();
        PricingStrategy newStrategy = new FacultyPricingStrategy();
        Booking booking = new Booking("B004", "R101", "U101", 9, 11, initialStrategy);
        
        booking.setPricingStrategy(newStrategy);
        assertEquals(newStrategy.calculateCost(2), booking.calculateTotalCost(), 0.001);
    }

    @Test
    public void testToStringFormat() {
        PricingStrategy strategy = new StudentPricingStrategy();
        Booking booking = new Booking("B005", "R101", "U101", 14, 16, strategy);
        String expected = "Booking[B005 room=R101 user=U101 14-16]";
        
        assertEquals(expected, booking.toString());
    }

    @Test
    public void testOneHourBookingCost() {
        PricingStrategy strategy = new FacultyPricingStrategy();
        Booking booking = new Booking("B006", "R202", "U102", 8, 9, strategy);
        
        assertEquals(strategy.calculateCost(1), booking.calculateTotalCost(), 0.001);
    }

    @Test
    public void testNullFieldsBookingCreation() {
        PricingStrategy strategy = new StudentPricingStrategy();
        Booking booking = new Booking(null, null, null, 0, 0, strategy);
        
        assertNull(booking.getId());
        assertNull(booking.getRoomId());
        assertNull(booking.getUserId());
    }

    @Test
    public void testCalculateTotalCostAfterStrategyChange() {
        PricingStrategy studentStrat = new StudentPricingStrategy();
        PricingStrategy facultyStrat = new FacultyPricingStrategy();
        Booking booking = new Booking("B007", "R101", "U101", 10, 12, studentStrat);
        
        double initialCost = booking.calculateTotalCost();
        booking.setPricingStrategy(facultyStrat);
        double updatedCost = booking.calculateTotalCost();
        
        assertNotEquals(initialCost, updatedCost, 0.001);
        assertEquals(facultyStrat.calculateCost(2), updatedCost, 0.001);
    }

    @Test
    public void testBookingTimeSpan() {
        PricingStrategy strategy = new StudentPricingStrategy();
        Booking booking = new Booking("B008", "R101", "U101", 10, 15, strategy);
        int duration = booking.getEndHour() - booking.getStartHour();
        
        assertEquals(5, duration);
    }

    @Test
    public void testGetUpfrontDepositReflectsStrategyRate() {
        PricingStrategy facultyStrat = new FacultyPricingStrategy();
        Booking booking = new Booking("B009", "R101", "U102", 9, 11, facultyStrat);
        
        assertEquals(facultyStrat.getHourlyRate(), booking.getUpfrontDeposit(), 0.001);
    }
}
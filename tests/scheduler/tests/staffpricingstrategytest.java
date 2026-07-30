package scheduler.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import scheduler.strategy.StaffPricingStrategy;

public class staffpricingstrategytest {

    private StaffPricingStrategy pricing;

    @Before
     public void setUp() {
        pricing = new StaffPricingStrategy();
    }

    @Test
    public void rateIsForty() {
        // staff pay 40 an hour
        assertEquals(40.0, pricing.getHourlyRate(), 0.001);
    }

    @Test
    public void rateIsPositive() {
        assertTrue(pricing.getHourlyRate() > 0);
    }

    @Test
    public void costForOneHour() {
         assertEquals(40.0, pricing.calculateCost(1), 0.001);
    }

    @Test
    public void costForTwoHours() { 
        assertEquals(80.0, pricing.calculateCost(2), 0.001);
    }

    @Test
    public void costForThreeHours() {
        assertEquals(120.0, pricing.calculateCost(3), 0.001);
    }

    @Test
    public void costForFiveHours() {
        assertEquals(200.0, pricing.calculateCost(5), 0.001);
    }

    	@Test
    public void costForFullDay() {
        // say 8 hours
        assertEquals(320.0, pricing.calculateCost(8), 0.001);
    }

    @Test
    public void costForZeroHoursIsZero() {
        assertEquals(0.0, pricing.calculateCost(0), 0.001);
    }

    @Test
    public void costIsHoursTimesRate() {
        // just checking the cost lines up with the rate
        assertEquals(4 * pricing.getHourlyRate(), pricing.calculateCost(4), 0.001); 
    }

    @Test
    public void costForNegativeHoursIsNegative() {
        // no guard in the code so a negative just gives a negative number
        assertEquals(-40.0, pricing.calculateCost(-1), 0.001); 
    }
}
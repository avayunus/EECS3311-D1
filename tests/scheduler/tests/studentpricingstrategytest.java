package scheduler.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import scheduler.strategy.StudentPricingStrategy;

public class studentpricingstrategytest {

     private StudentPricingStrategy pricing;

    @Before
    public void setUp() {
        pricing = new StudentPricingStrategy();
    }

    @Test
    public void rateIsTwenty() {
        // students pay 20 an hour
         assertEquals(20.0, pricing.getHourlyRate(), 0.001);
    }

    @Test
    public void rateIsPositive() {
        assertTrue(pricing.getHourlyRate() > 0);
    }

    @Test
    public void costForOneHour() {
        assertEquals(20.0, pricing.calculateCost(1), 0.001);
    }

    @Test
    public void costForTwoHours() {
        assertEquals(40.0, pricing.calculateCost(2), 0.001);
    }

    @Test
    public void costForThreeHours() {
        assertEquals(60.0, pricing.calculateCost(3), 0.001);
    }

    @Test
    public void costForFiveHours() {
        assertEquals(100.0, pricing.calculateCost(5), 0.001);
    }

    @Test
    public void costForFullDay() {
        // say 8 hours
        assertEquals(160.0, pricing.calculateCost(8), 0.001);
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
        // theres no guard in the code so a negative just gives a negative number
        assertEquals(-20.0, pricing.calculateCost(-1), 0.001);
    }
}
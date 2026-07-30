package scheduler.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import scheduler.strategy.FacultyPricingStrategy;

public class facultypricingstrategytest {

     private FacultyPricingStrategy pricing;

    @Before
    public void setUp() {
        pricing = new FacultyPricingStrategy();
    }

    @Test
    public void rateIsThirty() {
        // faculty pay 30 an hour
        assertEquals(30.0, pricing.getHourlyRate(), 0.001);
    }

     @Test
    public void rateIsPositive() {
        assertTrue(pricing.getHourlyRate() > 0);
    }

    @Test
     public void costForOneHour() {
        assertEquals(30.0, pricing.calculateCost(1), 0.001);
    }

    @Test
    public void costForTwoHours() {
        assertEquals(60.0, pricing.calculateCost(2), 0.001);
    }

    @Test
    public void costForThreeHours() {
        assertEquals(90.0, pricing.calculateCost(3), 0.001);
    }

    @Test
    public void costForFiveHours() {
        assertEquals(150.0, pricing.calculateCost(5), 0.001);
    }

    @Test
      public void costForFullDay() {
        // say 8 hours
         assertEquals(240.0, pricing.calculateCost(8), 0.001);
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
        assertEquals(-30.0, pricing.calculateCost(-1), 0.001);
    }
}
package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scheduler.strategy.StudentPricingStrategy;

public class StudentPricingStrategyTest {

    private StudentPricingStrategy strategy;

    @BeforeEach
    public void setUp() {
        strategy = new StudentPricingStrategy();
    }

    @Test
    public void testGetHourlyRate_returnsCorrectValue() {
        assertEquals(20.0, strategy.getHourlyRate(), 0.001);
    }

    @Test
    public void testCalculateCost_computesCorrectly() {
        assertEquals(0.0, strategy.calculateCost(0), 0.001);
        assertEquals(20.0, strategy.calculateCost(1), 0.001);
        assertEquals(60.0, strategy.calculateCost(3), 0.001);
    }
}
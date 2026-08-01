package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scheduler.strategy.PartnerPricingStrategy;

public class PartnerPricingStrategyTest {

    private PartnerPricingStrategy strategy;

    @BeforeEach
    public void setUp() {
        strategy = new PartnerPricingStrategy();
    }

    @Test
    public void testGetHourlyRate_returnsCorrectValue() {
        assertEquals(50.0, strategy.getHourlyRate(), 0.001);
    }

    @Test
    public void testCalculateCost_computesCorrectly() {
        assertEquals(0.0, strategy.calculateCost(0), 0.001);
        assertEquals(50.0, strategy.calculateCost(1), 0.001);
        assertEquals(150.0, strategy.calculateCost(3), 0.001);
    }
}
package scheduler.strategy;

public interface PricingStrategy {
    public double getHourlyRate ();
    public double calculateCost(int hours);
}

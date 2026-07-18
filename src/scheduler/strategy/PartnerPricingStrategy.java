package scheduler.strategy;

public class PartnerPricingStrategy {
    public double getHourlyRate (){return 50.0;}

    public double calculateCost(int hours){
        return hours * getHourlyRate();
    }
}

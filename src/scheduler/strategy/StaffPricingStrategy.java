package scheduler.strategy;

public class StaffPricingStrategy {
    public double getHourlyRate (){return 40.0;}

    public double calculateCost(int hours){
        return hours * getHourlyRate();
    }
}

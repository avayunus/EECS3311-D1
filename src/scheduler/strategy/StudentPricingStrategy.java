package scheduler.strategy;

public class StudentPricingStrategy {
    public double getHourlyRate (){return 20.0;}

    public double calculateCost(int hours){
        return hours * getHourlyRate();
    }
}

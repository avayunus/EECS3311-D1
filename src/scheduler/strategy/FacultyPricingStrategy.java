package scheduler.strategy;

public class FacultyPricingStrategy  implements PricingStrategy{
    public double getHourlyRate (){
        return 30.0;
    }

    public double calculateCost(int hours){
        return hours * getHourlyRate();
    }
}

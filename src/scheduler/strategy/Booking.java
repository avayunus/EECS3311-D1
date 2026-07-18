package scheduler.strategy;

//temporary for now since it should connect with the factory design pattern
public class Booking {
    private String bookingID;
    private int hours;
    private PricingStrategy pricingStrategy;

    public Booking(String bookingID, int hours, PricingStrategy pricingStrategy){
        this.bookingID = bookingID;
        this.hours = hours;
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateTotalCost(){

        return this.pricingStrategy.calculateCost(this.hours);
    }

    public double getUpfrontDeposit() {

        return this.pricingStrategy.getHourlyRate();
    }

    public void setPricingStrategy(PricingStrategy s){
       this.pricingStrategy = s;
    }
}

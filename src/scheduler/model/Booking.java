package scheduler.model;

import scheduler.strategy.PricingStrategy;

/**
 * STUB - belongs to the Domain model component. Replace with the group's
 * version (Christian's factory builds these). Fields are a guess; the only
 * thing BookingManager actually requires is getId().
 */
public class Booking {

    private final String id;
    private final String roomId;
    private final String userId;
    private final int startHour;
    private final int endHour;
    private PricingStrategy pricingStrategy;

    public Booking(String id, String roomId, String userId, int startHour, int endHour,PricingStrategy pricingStrategy) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.startHour = startHour;
        this.endHour = endHour;
        this.pricingStrategy = pricingStrategy;
    }

    public String getId() { return id; }
    public String getRoomId() { return roomId; }
    public String getUserId() { return userId; }
    public int getStartHour() { return startHour; }
    public int getEndHour() { return endHour; }


    public double calculateTotalCost(){

        return this.pricingStrategy.calculateCost(this.getEndHour() - this.getStartHour());
    }

    public double getUpfrontDeposit() {

        return this.pricingStrategy.getHourlyRate();
    }

    public void setPricingStrategy(PricingStrategy s){
        this.pricingStrategy = s;
    }

    @Override
    public String toString() {
        return "Booking[" + id + " room=" + roomId + " user=" + userId
                + " " + startHour + "-" + endHour + "]";
    }
}

package scheduler.model;

import java.util.UUID;
import scheduler.strategy.PricingStrategy;


public class BookingFactory {


    public static Booking createBooking(String roomId, String userId, int startHour, int endHour, PricingStrategy strategy) {
        String id = "b-" + UUID.randomUUID().toString().substring(0, 8);
        return new Booking(id, roomId, userId, startHour, endHour, strategy);
    }


    public static Booking createBooking(String id, String roomId, String userId, int startHour, int endHour, PricingStrategy strategy) {
        return new Booking(id, roomId, userId, startHour, endHour, strategy);
    }
}

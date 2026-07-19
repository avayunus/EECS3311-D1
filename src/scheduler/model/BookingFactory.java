package scheduler.model;

import java.util.UUID;


public class BookingFactory {


    public Booking createBooking(String roomId, String userId, int startHour, int endHour) {
        String id = "b-" + UUID.randomUUID().toString().substring(0, 8);
        return new Booking(id, roomId, userId, startHour, endHour);
    }


    public Booking createBooking(String id, String roomId, String userId, int startHour, int endHour) {
        return new Booking(id, roomId, userId, startHour, endHour);
    }
}

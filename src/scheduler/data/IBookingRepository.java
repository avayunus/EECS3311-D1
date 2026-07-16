package scheduler.data;

import java.util.List;
import scheduler.model.Booking;


public interface IBookingRepository {
    List<Booking> findAll();
    void save(Booking b);
    void delete(String id);
}

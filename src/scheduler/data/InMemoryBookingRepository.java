package scheduler.data;

import java.util.ArrayList;
import java.util.List;

import scheduler.model.Booking;

public class InMemoryBookingRepository implements IBookingRepository {

    private final List<Booking> rows = new ArrayList<Booking>();

    @Override
    public List<Booking> findAll() {
        return new ArrayList<Booking>(rows);
    }

    @Override
    public void save(Booking b) {
        delete(b.getId());
        rows.add(b);
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getId().equals(id)) {
                rows.remove(i);
                return;
            }
        }
    }
}

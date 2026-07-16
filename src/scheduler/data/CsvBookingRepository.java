package scheduler.data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import scheduler.model.Booking;

/**
 * CSV-backed booking store using the course javacsv library
 * (same CsvReader / CsvWriter API as CSV-example).
 */
public class CsvBookingRepository implements IBookingRepository {

    private final String path;
    private final List<Booking> cache = new ArrayList<Booking>();

    public CsvBookingRepository(String path) {
        this.path = path;
        load();
    }

    private void load() {
        cache.clear();
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        try {
            CsvReader reader = new CsvReader(path);
            reader.readHeaders();
            while (reader.readRecord()) {
                Booking booking = new Booking(
                        reader.get("id"),
                        reader.get("roomId"),
                        reader.get("userId"),
                        Integer.parseInt(reader.get("startHour").trim()),
                        Integer.parseInt(reader.get("endHour").trim()));
                cache.add(booking);
            }
            reader.close();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load bookings from " + path, e);
        }
    }

    private void writeAll() {
        try {
            CsvWriter writer = new CsvWriter(new FileWriter(path, false), ',');
            writer.write("id");
            writer.write("roomId");
            writer.write("userId");
            writer.write("startHour");
            writer.write("endHour");
            writer.endRecord();

            for (Booking booking : cache) {
                writer.write(booking.getId());
                writer.write(booking.getRoomId());
                writer.write(booking.getUserId());
                writer.write(String.valueOf(booking.getStartHour()));
                writer.write(String.valueOf(booking.getEndHour()));
                writer.endRecord();
            }
            writer.close();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to write bookings to " + path, e);
        }
    }

    private boolean removeFromCache(String id) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getId().equals(id)) {
                cache.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<Booking>(cache);
    }

    @Override
    public void save(Booking booking) {
        if (booking == null) {
            return;
        }
        removeFromCache(booking.getId());
        cache.add(booking);
        writeAll();
    }

    @Override
    public void delete(String id) {
        if (removeFromCache(id)) {
            writeAll();
        }
    }
}

package scheduler.data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import scheduler.model.Booking;

/**
 * Aleena's Adapter / DAP implementation.
 * Adapts the low level, third party CsvReader/CsvWriter library 
 * to meet our system's clean IBookingRepository interface.
 */
public class CSVBookingAdapter implements IBookingRepository {

    private final String csvFilePath;

    public CSVBookingAdapter(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> bookings = new ArrayList<>();
        File file = new File(csvFilePath);
        
        if (!file.exists()) {
            return bookings;
        }

        try {
            CsvReader reader = new CsvReader(csvFilePath);
            reader.readHeaders();
            
            while (reader.readRecord()) {
                // Adapting raw string record data into a clean Booking object
                Booking booking = new Booking(
                        reader.get("id"),
                        reader.get("roomId"),
                        reader.get("userId"),
                        Integer.parseInt(reader.get("startHour").trim()),
                        Integer.parseInt(reader.get("endHour").trim())
                );
                bookings.add(booking);
            }
            reader.close();
        } catch (Exception e) {
            throw new IllegalStateException("Adapter failed to read from data source: " + csvFilePath, e);
        }
        return bookings;
    }

    @Override
    public void save(Booking b) {
        if (b == null) return;
        
        // Read existing bookings first so we don't overwrite everything
        List<Booking> currentBookings = findAll();
        
        // Remove old version if it's an update
        currentBookings.removeIf(existing -> existing.getId().equals(b.getId()));
        currentBookings.add(b);

        try {
            CsvWriter writer = new CsvWriter(new FileWriter(csvFilePath, false), ',');
            writer.write("id");
            writer.write("roomId");
            writer.write("userId");
            writer.write("startHour");
            writer.write("endHour");
            writer.endRecord();

            for (Booking booking : currentBookings) {
                writer.write(booking.getId());
                writer.write(booking.getRoomId());
                writer.write(booking.getUserId());
                writer.write(String.valueOf(booking.getStartHour()));
                writer.write(String.valueOf(booking.getEndHour()));
                writer.endRecord();
            }
            writer.close();
        } catch (Exception e) {
            throw new IllegalStateException("Adapter failed to write to data source: " + csvFilePath, e);
        }
    }

    @Override
    public void delete(String id) {
        List<Booking> currentBookings = findAll();
        if (currentBookings.removeIf(existing -> existing.getId().equals(id))) {
            // Rewrite the file without the deleted record
            try {
                CsvWriter writer = new CsvWriter(new FileWriter(csvFilePath, false), ',');
                writer.write("id");
                writer.write("roomId");
                writer.write("userId");
                writer.write("startHour");
                writer.write("endHour");
                writer.endRecord();

                for (Booking booking : currentBookings) {
                    writer.write(booking.getId());
                    writer.write(booking.getRoomId());
                    writer.write(booking.getUserId());
                    writer.write(String.valueOf(booking.getStartHour()));
                    writer.write(String.valueOf(booking.getEndHour()));
                    writer.endRecord();
                }
                writer.close();
            } catch (Exception e) {
                throw new IllegalStateException("Adapter failed to update after deletion: " + csvFilePath, e);
            }
        }
    }
}
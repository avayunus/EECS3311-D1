package scheduler.data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import scheduler.model.Room;

/**
 * CSV-backed room store (Req6 status + Req7 identity / capacity / location).
 */
public class CsvRoomRepository implements IRoomRepository {

    private final String path;
    private final List<Room> cache = new ArrayList<Room>();

    public CsvRoomRepository(String path) {
        this.path = path;
        load();
    }

    private void load() {
        cache.clear();
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        CsvReader reader = null;
        try {
            reader = new CsvReader(path);
            reader.readHeaders();
            while (reader.readRecord()) {
                String status = reader.get("status");
                if (status == null || status.isBlank()) {
                    status = "AVAILABLE";
                }
                Room room = new Room(
                        reader.get("id"),
                        reader.get("name"),
                        Integer.parseInt(reader.get("capacity").trim()),
                        reader.get("building"),
                        status.trim());
                cache.add(room);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load rooms from " + path, e);
        }
        finally {
            // This guarantees the file handle is released even when parsing crashes!
            if (reader != null) {
                reader.close();
            }
        }
    }

    private void writeAll() {
        try {
            CsvWriter  writer = new CsvWriter(new FileWriter(path, false), ',');
            writer.write("id");
            writer.write("name");
            writer.write("capacity");
            writer.write("building");
            writer.write("status");
            writer.endRecord();

            for (Room room : cache) {
                writer.write(room.getId());
                writer.write(room.getName());
                writer.write(String.valueOf(room.getCapacity()));
                writer.write(room.getBuilding());
                writer.write(room.getStatus());
                writer.endRecord();
            }
            writer.close();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to write rooms to " + path, e);
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
    public List<Room> findAll() {
        return new ArrayList<Room>(cache);
    }

    @Override
    public Room findById(String id) {
        for (Room room : cache) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void save(Room room) {
        if (room == null) {
            return;
        }
        removeFromCache(room.getId());
        cache.add(room);
        writeAll();
    }
}

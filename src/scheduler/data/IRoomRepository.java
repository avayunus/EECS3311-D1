package scheduler.data;

import java.util.List;

import scheduler.model.Room;

public interface IRoomRepository {
    List<Room> findAll();

    Room findById(String id);

    void save(Room room);
}

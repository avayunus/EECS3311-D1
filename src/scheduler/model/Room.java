package scheduler.model;

/**
 * Room loaded from rooms.csv. Domain fields align with Req6/Req7
 * (unique id, capacity, building/location, enable/disable status).
 */
public class Room {

    private final String id;
    private final String name;
    private final int capacity;
    private final String building;
    private final String status;

    public Room(String id, String name, int capacity, String building, String status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.building = building;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBuilding() {
        return building;
    }

    public String getStatus() {
        return status;
    }

    public boolean isBookable() {
        return "AVAILABLE".equalsIgnoreCase(status);
    }

    @Override
    public String toString() {
        return "Room[" + id + " " + name + " cap=" + capacity
                + " " + building + " status=" + status + "]";
    }
}

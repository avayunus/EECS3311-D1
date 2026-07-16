package scheduler.model;

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

    public Booking(String id, String roomId, String userId, int startHour, int endHour) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getId() { return id; }
    public String getRoomId() { return roomId; }
    public String getUserId() { return userId; }
    public int getStartHour() { return startHour; }
    public int getEndHour() { return endHour; }

    @Override
    public String toString() {
        return "Booking[" + id + " room=" + roomId + " user=" + userId
                + " " + startHour + "-" + endHour + "]";
    }
}

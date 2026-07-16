package scheduler.model;

/**
 * Hourly window used by SchedulerFacade.requestBooking(...).
 */
public class TimeSlot {

    private final int startHour;
    private final int endHour;

    public TimeSlot(int startHour, int endHour) {
        if (endHour <= startHour) {
            throw new IllegalArgumentException(
                    "endHour must be after startHour (got " + startHour + "-" + endHour + ")");
        }
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    @Override
    public String toString() {
        return startHour + "-" + endHour;
    }
}

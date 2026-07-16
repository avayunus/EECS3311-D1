package scheduler.rules;

import java.util.List;

import scheduler.model.Booking;

public class NoOverlapRule implements IConflictRules {

    @Override
    public boolean isAllowed(Booking candidate, List<Booking> existing) {
        for (Booking b : existing) {
            if (!b.getRoomId().equals(candidate.getRoomId())) {
                continue;
            }
            boolean overlaps = candidate.getStartHour() < b.getEndHour()
                    && b.getStartHour() < candidate.getEndHour();
            if (overlaps) {
                return false;
            }
        }
        return true;
    }
}

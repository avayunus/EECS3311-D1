package scheduler.rules;

import java.util.List;
import scheduler.model.Booking;


public interface IConflictRules {
    boolean isAllowed(Booking candidate, List<Booking> existing);
}

package scheduler.booking;

import java.util.ArrayList;
import java.util.List;

import scheduler.data.IBookingRepository;
import scheduler.model.Booking;
import scheduler.rules.IConflictRules;

/**
 * Singleton
 */
public class BookingManager {

    private static BookingManager instance;

    private final List<Booking> bookings = new ArrayList<Booking>();
    private final List<BookingObserver> observers = new ArrayList<BookingObserver>();

    private IBookingRepository repo;
    private IConflictRules rules;

    private BookingManager() {
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

    /**
     * Called from Main at startup
   
     */
    public void initialize(IBookingRepository repo, IConflictRules rules) {
        this.repo = repo;
        this.rules = rules;
        this.bookings.clear();
        this.bookings.addAll(repo.findAll());
        notifyObservers();
    }

    /**
     * Rejects the booking if it conflicts with an existing one
     */
    public boolean addBooking(Booking b) {
        requireInitialized();
        if (b == null) {
            return false;
        }
        if (!rules.isAllowed(b, getBookings())) {
            return false;
        }
        repo.save(b);
        bookings.add(b);
        notifyObservers();
        return true;
    }

    public boolean cancelBooking(String id) {
        requireInitialized();
        Booking found = findById(id);
        if (found == null) {
            return false;
        }
        repo.delete(id);
        bookings.remove(found);
        notifyObservers();
        return true;
    }

    /**
     * Returns a copy
     */
    public List<Booking> getBookings() {
        return new ArrayList<Booking>(bookings);
    }

    public Booking findById(String id) {
        for (Booking b : bookings) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    // Observer support --------

    public void register(BookingObserver o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    public void unregister(BookingObserver o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (BookingObserver o : new ArrayList<BookingObserver>(observers)) {
            o.onBookingsChanged();
        }
    }

    private void requireInitialized() {
        if (repo == null || rules == null) {
            throw new IllegalStateException(
                    "BookingManager.initialize(repo, rules) must be called before use.");
        }
    }
}

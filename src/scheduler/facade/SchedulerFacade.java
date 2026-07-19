package scheduler.facade;

import java.util.List;
import java.util.UUID;

import scheduler.booking.BookingManager;
import scheduler.booking.BookingObserver;
import scheduler.data.IBookingRepository;
import scheduler.data.IRoomRepository;
import scheduler.data.IUserRepository;
import scheduler.model.Booking;
import scheduler.model.BookingFactory;
import scheduler.model.Room;
import scheduler.model.TimeSlot;
import scheduler.model.User;
import scheduler.rules.IConflictRules;
import scheduler.strategy.PricingStrategy;

/**
 * Facade — single entry point the GUI (and Main) should call.
 * Hides BookingManager singleton wiring plus CSV room/user repositories.
 */
public class SchedulerFacade {

    private final BookingManager bookingManager;
    private final IRoomRepository roomRepository;
    private final IUserRepository userRepository;
    private final BookingFactory bookingFactory = new BookingFactory();


    public SchedulerFacade(IRoomRepository roomRepository, IUserRepository userRepository) {
        this.bookingManager = BookingManager.getInstance();
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    /**
     * Wire the singleton BookingManager with persistence + conflict rules.
     * Call once at application startup.
     */
    public void start(IBookingRepository bookingRepository, IConflictRules rules) {
        bookingManager.initialize(bookingRepository, rules);
    }

    /**
     * High-level book request used by the GUI (matches Ava's Singleton diagram).
     * Rejects disabled/maintenance rooms and delegates conflict checks to BookingManager.
     */
    public boolean requestBooking(Room room, TimeSlot slot, String userId, PricingStrategy strategy) {
        if (room == null || slot == null || userId == null || userId.isBlank()) {
            return false;
        }
        Room known = roomRepository.findById(room.getId());
        if (known == null || !known.isBookable()) {
            return false;
        }
        String bookingId = "b-" + UUID.randomUUID().toString().substring(0, 8);
        Booking booking = bookingFactory.createBooking(
                known.getId(),
                userId,
                slot.getStartHour(),
                slot.getEndHour(),
                strategy);
        return bookingManager.addBooking(booking);
    }

    /** Convenience overload when the caller only has a room id. */
    public boolean requestBooking(String roomId, TimeSlot slot, String userId, PricingStrategy strategy) {
        return requestBooking(roomRepository.findById(roomId), slot, userId, strategy);
    }

    public boolean cancelBooking(String bookingId) {
        return bookingManager.cancelBooking(bookingId);
    }

    public List<Booking> getBookings() {
        return bookingManager.getBookings();
    }

    public Booking findBooking(String bookingId) {
        return bookingManager.findById(bookingId);
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room findRoom(String roomId) {
        return roomRepository.findById(roomId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUser(String userId) {
        return userRepository.findById(userId);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /** Forward observer registration so the GUI does not touch BookingManager. */
    public void registerObserver(BookingObserver observer) {
        bookingManager.register(observer);
    }

    public void unregisterObserver(BookingObserver observer) {
        bookingManager.unregister(observer);
    }
}

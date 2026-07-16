package scheduler.booking;

public interface BookingSubject {
    void register(BookingObserver observer);

    void unregister(BookingObserver observer);

    void notifyObservers();
}
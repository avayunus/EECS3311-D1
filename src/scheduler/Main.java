package scheduler;

import scheduler.booking.BookingManager;
import scheduler.data.InMemoryBookingRepository;
import scheduler.model.Booking;
import scheduler.rules.NoOverlapRule;


public class Main {

    public static void main(String[] args) {

        BookingManager.getInstance().initialize(
                new InMemoryBookingRepository(),
                new NoOverlapRule());

        BookingManager mgr = BookingManager.getInstance();

        System.out.println("Add b1 (LAS1004, 9-11):   " + mgr.addBooking(
                new Booking("b1", "LAS1004", "ayunus", 9, 11)));

        System.out.println("Add b2 (LAS1004, 10-12):  " + mgr.addBooking(
                new Booking("b2", "LAS1004", "trobel", 10, 12))
                + "   <- must be false, overlaps b1");

        System.out.println("Add b3 (LAS2005, 10-12):  " + mgr.addBooking(
                new Booking("b3", "LAS2005", "trobel", 10, 12))
                + "    <- different room, fine");

        System.out.println("Add b4 (LAS1004, 11-13):  " + mgr.addBooking(
                new Booking("b4", "LAS1004", "amalik", 11, 13))
                + "    <- touches b1's end, no overlap");

        System.out.println("\nBookings now: " + mgr.getBookings().size());
        for (Booking b : mgr.getBookings()) {
            System.out.println("  " + b);
        }

        System.out.println("\nCancel b1: " + mgr.cancelBooking("b1"));
        System.out.println("Cancel b9 (not there): " + mgr.cancelBooking("b9"));

        System.out.println("\nSame instance every time? "
                + (BookingManager.getInstance() == mgr));

        System.out.println("Bookings after cancel: " + mgr.getBookings().size());
    }
}

package scheduler;

import scheduler.data.CsvBookingRepository;
import scheduler.data.CSVBookingAdapter;
import scheduler.data.CsvRoomRepository;
import scheduler.data.CsvUserRepository;
import scheduler.facade.SchedulerFacade;
import scheduler.model.Booking;
import scheduler.model.Room;
import scheduler.model.TimeSlot;
import scheduler.model.User;
import scheduler.rules.NoOverlapRule;

/**
 * Demo entry point for Abel's Facade + CSV data layer.
 * Run from the project root so bookings.csv / rooms.csv / users.csv resolve.
 */
public class Main {

    public static void main(String[] args) {
        SchedulerFacade facade = new SchedulerFacade(
                new CsvRoomRepository("rooms.csv"),
                new CsvUserRepository("users.csv"));

        facade.start(new CSVBookingAdapter("bookings.csv"), new NoOverlapRule());

        System.out.println("=== Rooms (from rooms.csv) ===");
        for (Room room : facade.getRooms()) {
            System.out.println("  " + room);
        }

        System.out.println("\n=== Users (from users.csv) ===");
        for (User user : facade.getUsers()) {
            System.out.println("  " + user + " rate=$" + user.getHourlyRate() + "/hr");
        }

        System.out.println("\n=== Bookings loaded from bookings.csv ===");
        for (Booking booking : facade.getBookings()) {
            System.out.println("  " + booking);
        }

        Room seminar = facade.findRoom("LAS1004");
        Room lounge = facade.findRoom("LAS1007");

        System.out.println("\n=== Facade booking checks ===");
        boolean overlapRejected = facade.requestBooking(
                seminar, new TimeSlot(9, 11), "trobel");
        System.out.println("Overlap on LAS1004 9-11: " + overlapRejected
                + "  <- must be false (conflicts with b1 9-10)");

        boolean maintenanceRejected = facade.requestBooking(
                lounge, new TimeSlot(10, 12), "asabu");
        System.out.println("Book MAINTENANCE lounge: " + maintenanceRejected
                + "  <- must be false");

        boolean accepted = facade.requestBooking(
                seminar, new TimeSlot(11, 13), "asabu");
        System.out.println("Book LAS1004 11-13: " + accepted
                + "  <- must be true");

        System.out.println("\nBookings after successful add: " + facade.getBookings().size());
        for (Booking booking : facade.getBookings()) {
            System.out.println("  " + booking);
        }

        // Keep sample CSV clean: cancel whatever we just added for 11-13.
        Booking added = null;
        for (Booking booking : facade.getBookings()) {
            if ("LAS1004".equals(booking.getRoomId())
                    && booking.getStartHour() == 11
                    && booking.getEndHour() == 13) {
                added = booking;
                break;
            }
        }
        if (added != null) {
            System.out.println("\nCleanup cancel " + added.getId() + ": "
                    + facade.cancelBooking(added.getId()));
        }

        System.out.println("Final booking count (sample restored): "
                + facade.getBookings().size());
   
        javax.swing.SwingUtilities.invokeLater(
                () -> new scheduler.gui.BookingApp(facade).setVisible(true));
        
    }


}



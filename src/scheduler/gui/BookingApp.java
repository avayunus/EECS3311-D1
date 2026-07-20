package scheduler.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import scheduler.data.CSVBookingAdapter;
import scheduler.data.CsvRoomRepository;
import scheduler.data.CsvUserRepository;
import scheduler.facade.SchedulerFacade;
import scheduler.model.Room;
import scheduler.model.TimeSlot;
import scheduler.model.User;
import scheduler.rules.NoOverlapRule;


public class BookingApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private final SchedulerFacade facade;
    private final JComboBox<String> roomBox = new JComboBox<>();
    private final JComboBox<String> userBox = new JComboBox<>();
    private final JSpinner startSpinner = new JSpinner(new SpinnerNumberModel(9, 0, 23, 1));
    private final JSpinner endSpinner = new JSpinner(new SpinnerNumberModel(10, 1, 24, 1));

    public BookingApp(SchedulerFacade facade) {
        super("Conference Room Scheduler");
        this.facade = facade;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));

        add(buildBookingForm(), BorderLayout.WEST);
        add(new MyBookingsPanel(facade), BorderLayout.CENTER);

        populateDropdowns();

        setSize(820, 420);
        setLocationRelativeTo(null);
    }

    private JPanel buildBookingForm() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Create a Booking"));

        form.add(new JLabel("Room:"));
        form.add(roomBox);
        form.add(new JLabel("User:"));
        form.add(userBox);
        form.add(new JLabel("Start hour:"));
        form.add(startSpinner);
        form.add(new JLabel("End hour:"));
        form.add(endSpinner);

        JButton bookButton = new JButton("Book Room");
        bookButton.addActionListener(event -> handleBook());
        form.add(new JLabel());
        form.add(bookButton);

        return form;
    }

    private void populateDropdowns() {
        for (Room room : facade.getRooms()) {
            roomBox.addItem(room.getId() + " - " + room.getName()
                    + (room.isBookable() ? "" : " (" + room.getStatus() + ")"));
        }
        for (User user : facade.getUsers()) {
            userBox.addItem(user.getId());
        }
    }

    private void handleBook() {
        if (roomBox.getSelectedItem() == null || userBox.getSelectedItem() == null) {
            return;
        }

        String roomId = ((String) roomBox.getSelectedItem()).split(" - ")[0];
        String userId = (String) userBox.getSelectedItem();
        int start = (Integer) startSpinner.getValue();
        int end = (Integer) endSpinner.getValue();

        if (end <= start) {
            JOptionPane.showMessageDialog(this,
                    "End hour must be after start hour.",
                    "Invalid Time", JOptionPane.WARNING_MESSAGE);
            return;
        }

        User selectedUser = facade.findUser(userId);

        if (selectedUser == null) {
            JOptionPane.showMessageDialog(this, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        scheduler.strategy.PricingStrategy strategy = selectedUser.getPricingStrategy();

        boolean booked = facade.requestBooking(roomId, new TimeSlot(start, end), userId, strategy);

        if (booked) {
            int hours = end - start;
            double hourlyRate = strategy.getHourlyRate();
            double totalCost = strategy.calculateCost(hours);
            double deposit = hourlyRate; // Assuming the upfront deposit equals 1 hour of room usage

            String confirmationMessage = String.format(
                    "Booking Confirmed!\n\n" +
                            "Room: %s\n" +
                            "User: %s (%s)\n" +
                            "Time: %d:00 - %d:00 (%d hours)\n" +
                            "-----------------------------------\n" +
                            "Hourly Rate: $%.2f / hr\n" +
                            "Upfront Deposit Due: $%.2f\n" +
                            "Total Expected Cost: $%.2f",
                    roomId, userId, selectedUser.getAccountType(), start, end, hours, hourlyRate, deposit, totalCost
            );

            JOptionPane.showMessageDialog(this,
                    confirmationMessage,
                    "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Could not book. The room may be unavailable or already booked for that time.",
                    "Booking Rejected", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public static void main(String[] args) {
        SchedulerFacade facade = new SchedulerFacade(
                new CsvRoomRepository("rooms.csv"),
                new CsvUserRepository("users.csv"));
        facade.start(new CSVBookingAdapter("bookings.csv"), new NoOverlapRule());

        SwingUtilities.invokeLater(() -> new BookingApp(facade).setVisible(true));
    }
}

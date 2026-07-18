package scheduler.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import scheduler.booking.BookingObserver;
import scheduler.facade.SchedulerFacade;
import scheduler.model.Booking;
import scheduler.model.Room;
import scheduler.model.User;

public class MyBookingsPanel extends JPanel implements BookingObserver {

    private static final long serialVersionUID = 1L;

    private final SchedulerFacade facade;
    private final DefaultTableModel tableModel;
    private final JTable bookingTable;
    private boolean observerRegistered;

    public MyBookingsPanel(SchedulerFacade facade) {
        if (facade == null) {
            throw new IllegalArgumentException("SchedulerFacade cannot be null.");
        }

        this.facade = facade;
        this.tableModel = new DefaultTableModel(
                new String[] {"Booking ID", "Room", "User", "Start", "End"},
                0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.bookingTable = new JTable(tableModel);

        setLayout(new BorderLayout(12, 12));
        setBorder(BorderFactory.createTitledBorder("My Bookings"));

        add(new JLabel("Bookings refresh automatically after create and cancel."), BorderLayout.NORTH);
        add(new JScrollPane(bookingTable), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        facade.registerObserver(this);
        observerRegistered = true;
        refreshBookingTable();
    }

    private JPanel createButtonPanel() {
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(event -> refreshBookingTable());

        JButton cancelButton = new JButton("Cancel Booking");
        cancelButton.addActionListener(event -> cancelSelectedBooking());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(refreshButton);
        buttonPanel.add(cancelButton);
        return buttonPanel;
    }

    private void cancelSelectedBooking() {
        int selectedRow = bookingTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Select a booking first.",
                    "No Booking Selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String bookingId = String.valueOf(tableModel.getValueAt(selectedRow, 0));
        boolean cancelled = facade.cancelBooking(bookingId);

        if (!cancelled) {
            JOptionPane.showMessageDialog(
                    this,
                    "The booking could not be cancelled.",
                    "Cancellation Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onBookingsChanged() {
        SwingUtilities.invokeLater(this::refreshBookingTable);
    }

    private void refreshBookingTable() {
        tableModel.setRowCount(0);

        List<Booking> bookings = facade.getBookings();
        for (Booking booking : bookings) {
            Room room = facade.findRoom(booking.getRoomId());
            User user = facade.findUser(booking.getUserId());

            tableModel.addRow(new Object[] {
                    booking.getId(),
                    room == null ? booking.getRoomId() : room.getId(),
                    user == null ? booking.getUserId() : user.getId(),
                    booking.getStartHour(),
                    booking.getEndHour()
            });
        }
    }

    @Override
    public void removeNotify() {
        if (observerRegistered) {
            facade.unregisterObserver(this);
            observerRegistered = false;
        }
        super.removeNotify();
    }
}
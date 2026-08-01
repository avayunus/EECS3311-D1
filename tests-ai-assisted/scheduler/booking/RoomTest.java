package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import scheduler.model.Room;

public class RoomTest {

    // --- CONSTRUCTOR & GETTER VALIDATION TESTS ---

    @Test
    public void testRoomConstructorAndGetters_createsRightObject() {
        Room room = new Room("r-101", "Lecture Hall A", 150, "Lassonde", "AVAILABLE");

        // Verify all fields are correctly initialized and accessible
        assertNotNull(room, "Room instance allocation should succeed.");
        assertEquals("r-101", room.getId());
        assertEquals("Lecture Hall A", room.getName());
        assertEquals(150, room.getCapacity());
        assertEquals("Lassonde", room.getBuilding());
        assertEquals("AVAILABLE", room.getStatus());
    }

    // --- BUSINESS METHOD PATH TESTS (isBookable) ---

    @Test
    public void testIsBookable_trueOnExactAvailableStatus() {
        Room room = new Room("r-1", "Lab A", 30, "Bergeron", "AVAILABLE");
        assertTrue(room.isBookable(), "Room should be bookable when status is exactly AVAILABLE.");
    }

    @Test
    public void testIsBookable_trueOnMixedCaseAvailableStatus() {
        // The code uses equalsIgnoreCase, so this tests branch variance coverage
        Room room = new Room("r-2", "Lab B", 35, "Bergeron", "AvAiLaBlE");
        assertTrue(room.isBookable(), "Room should be bookable regardless of the string character case layout.");
    }

    @Test
    public void testIsBookable_falseOnNonAvailableStatuses() {
        // Case 1: Status is set to MAINTENANCE
        Room roomMaintenance = new Room("r-3", "Lab C", 40, "Steacie", "MAINTENANCE");
        assertFalse(roomMaintenance.isBookable(), "Room should not be bookable when under maintenance status.");

        // Case 2: Status is completely blank or unconfigured
        Room roomDisabled = new Room("r-4", "Lab D", 12, "Steacie", "DISABLED");
        assertFalse(roomDisabled.isBookable(), "Room should not be bookable when explicitly disabled.");
    }

    // --- TEXT SERIALIZATION TESTS ---

    @Test
    public void testToString_formatsExpectedStringRepresentation() {
        Room room = new Room("r-99", "Conference Room", 15, "Life Sciences", "OCCUPIED");

        String expectedString = "Room[r-99 Conference Room cap=15 Life Sciences status=OCCUPIED]";
        assertEquals(expectedString, room.toString(), "toString format must match the defined structural output.");
    }
}
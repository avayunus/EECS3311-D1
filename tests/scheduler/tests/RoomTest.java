package scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import scheduler.model.Room;

public class RoomTest {

    @Test
    public void testRoomCreationAndGetters() {
        Room room = new Room("R101", "Lassonde 1001", 50, "Lassonde", "AVAILABLE");
        
        assertNotNull(room);
        assertEquals("R101", room.getId());
        assertEquals("Lassonde 1001", room.getName());
        assertEquals(50, room.getCapacity());
        assertEquals("Lassonde", room.getBuilding());
        assertEquals("AVAILABLE", room.getStatus());
    }

    @Test
    public void testIsBookableWhenAvailable() {
        Room room = new Room("R101", "Lab 1", 30, "Lassonde", "AVAILABLE");
        assertTrue(room.isBookable());
    }

    @Test
    public void testIsBookableCaseInsensitive() {
        Room roomLower = new Room("R102", "Lab 2", 30, "Lassonde", "available");
        Room roomMixed = new Room("R103", "Lab 3", 30, "Lassonde", "Available");
        
        assertTrue(roomLower.isBookable());
        assertTrue(roomMixed.isBookable());
    }

    @Test
    public void testIsBookableWhenMaintenance() {
        Room room = new Room("R104", "Lab 4", 20, "Bergeron", "MAINTENANCE");
        assertFalse(room.isBookable());
    }

    @Test
    public void testIsBookableWhenDisabled() {
        Room room = new Room("R105", "Lab 5", 20, "Bergeron", "DISABLED");
        assertFalse(room.isBookable());
    }

    @Test
    public void testIsBookableWhenNullStatus() {
        Room room = new Room("R106", "Lab 6", 20, "Bergeron", null);
        assertFalse(room.isBookable());
    }

    @Test
    public void testToStringFormat() {
        Room room = new Room("R101", "Lassonde 1001", 50, "Lassonde", "AVAILABLE");
        String expected = "Room[R101 Lassonde 1001 cap=50 Lassonde status=AVAILABLE]";
        
        assertEquals(expected, room.toString());
    }

    @Test
    public void testZeroCapacityRoom() {
        Room room = new Room("R107", "Storage Room", 0, "Steacie", "DISABLED");
        assertEquals(0, room.getCapacity());
    }

    @Test
    public void testLargeCapacityRoom() {
        Room room = new Room("R108", "Auditorium", 300, "Vari Hall", "AVAILABLE");
        assertEquals(300, room.getCapacity());
        assertTrue(room.isBookable());
    }

    @Test
    public void testEmptyFieldsRoom() {
        Room room = new Room("", "", 10, "", "");
        assertEquals("", room.getId());
        assertEquals("", room.getName());
        assertEquals("", room.getBuilding());
        assertFalse(room.isBookable());
    }
}
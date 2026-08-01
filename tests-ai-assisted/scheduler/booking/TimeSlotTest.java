package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import scheduler.model.TimeSlot;

public class TimeSlotTest {

    // --- HAPPY PATH VALIDATION TESTS ---

    @Test
    public void testTimeSlotConstructorAndGetters_createsRightObject() {
        TimeSlot slot = new TimeSlot(9, 13);

        // Verify that valid constructor inputs are stored and returned cleanly
        assertNotNull(slot, "TimeSlot initialization should succeed for normal operating windows.");
        assertEquals(9, slot.getStartHour());
        assertEquals(13, slot.getEndHour());
    }

    // --- DEFENSIVE CONSTRUCTOR BRANCH TESTS ---

    @Test
    public void testConstructor_throwsExceptionWhenEndHourIsEqualToStartHour() {
        // Boundary condition where endHour == startHour
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeSlot(10, 10);
        }, "Should deny window initialization where duration calculates out to zero hours.");

        assertTrue(exception.getMessage().contains("endHour must be after startHour"));
    }

    @Test
    public void testConstructor_throwsExceptionWhenEndHourIsLessThanStartHour() {
        // Negative duration condition where endHour < startHour
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TimeSlot(15, 14);
        }, "Should deny window initialization where structural inputs calculate to negative intervals.");

        assertTrue(exception.getMessage().contains("endHour must be after startHour"));
    }

    // --- TEXT SERIALIZATION TESTS ---

    @Test
    public void testToString_formatsExpectedStringRepresentation() {
        TimeSlot slot = new TimeSlot(14, 16);

        String expectedString = "14-16";
        assertEquals(expectedString, slot.toString(), "toString format must match the hyphenated start-end pattern output.");
    }
}
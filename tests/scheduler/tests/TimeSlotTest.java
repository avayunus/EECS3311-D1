package scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import scheduler.model.TimeSlot;

public class TimeSlotTest {

    @Test
    public void testValidTimeSlotCreation() {
        TimeSlot slot = new TimeSlot(9, 11);
        assertNotNull(slot);
        assertEquals(9, slot.getStartHour());
        assertEquals(11, slot.getEndHour());
    }

    @Test
    public void testGetStartHour() {
        TimeSlot slot = new TimeSlot(10, 12);
        assertEquals(10, slot.getStartHour());
    }

    @Test
    public void testGetEndHour() {
        TimeSlot slot = new TimeSlot(10, 12);
        assertEquals(12, slot.getEndHour());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEndHourEqualToStartHourThrowsException() {
        new TimeSlot(10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEndHourBeforeStartHourThrowsException() {
        new TimeSlot(14, 12);
    }

    @Test
    public void testSingleHourSlot() {
        TimeSlot slot = new TimeSlot(13, 14);
        assertEquals(1, slot.getEndHour() - slot.getStartHour());
    }

    @Test
    public void testFullDaySpanSlot() {
        TimeSlot slot = new TimeSlot(8, 20);
        assertEquals(8, slot.getStartHour());
        assertEquals(20, slot.getEndHour());
    }

    @Test
    public void testToStringFormat() {
        TimeSlot slot = new TimeSlot(9, 11);
        assertEquals("9-11", slot.toString());
    }

    @Test
    public void testToStringAfternoonHours() {
        TimeSlot slot = new TimeSlot(14, 16);
        assertEquals("14-16", slot.toString());
    }

    @Test
    public void testNegativeOrZeroStartHourCreation() {
        // Checking behavior with 0 as midnight or early start
        TimeSlot slot = new TimeSlot(0, 5);
        assertEquals(0, slot.getStartHour());
        assertEquals(5, slot.getEndHour());
    }
}
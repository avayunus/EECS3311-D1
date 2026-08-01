package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import scheduler.model.User;
import scheduler.strategy.*;

public class UserTest {

    // --- CONSTRUCTOR & SIMPLE ACCESSOR TESTS ---

    @Test
    public void testUserConstructorAndGetters_createsRightObject() {
        User user = new User("u-001", "test@yorku.ca", "pass123", "student", "219000000", true);

        assertNotNull(user, "User initialization should succeed.");
        assertEquals("u-001", user.getId());
        assertEquals("test@yorku.ca", user.getEmail());
        assertEquals("pass123", user.getPassword());
        assertEquals("student", user.getAccountType());
        assertEquals("219000000", user.getOrgOrStudentId());
        assertTrue(user.isVerified());
    }

    // --- CONSTRUCTOR SWITCH BRANCH STRATEGY TESTS ---

    @Test
    public void testConstructor_assignsStudentPricingStrategy() {
        // Test exact match, mixed case, and trimming
        User user = new User("u-1", "s@yorku.ca", "p", "  StUdEnT  ", "123", true);

        assertTrue(user.getPricingStrategy() instanceof StudentPricingStrategy,
                "Should resolve to StudentPricingStrategy.");
    }

    @Test
    public void testConstructor_assignsFacultyPricingStrategy() {
        User user = new User("u-2", "f@yorku.ca", "p", "faculty", "456", true);

        assertTrue(user.getPricingStrategy() instanceof FacultyPricingStrategy,
                "Should resolve to FacultyPricingStrategy.");
    }

    @Test
    public void testConstructor_assignsStaffPricingStrategy() {
        User user = new User("u-3", "st@yorku.ca", "p", "staff", "789", true);

        assertTrue(user.getPricingStrategy() instanceof StaffPricingStrategy,
                "Should resolve to StaffPricingStrategy.");
    }

    @Test
    public void testConstructor_assignsPartnerPricingStrategyExplicitly() {
        User user = new User("u-4", "p@yorku.ca", "p", "partner", "012", true);

        assertTrue(user.getPricingStrategy() instanceof PartnerPricingStrategy,
                "Should resolve to PartnerPricingStrategy.");
    }

    @Test
    public void testConstructor_fallbackToDefaultPartnerStrategyOnNullOrUnknown() {
        // Case 1: Unrecognized string value drops into default
        User userUnknown = new User("u-5", "unk@yorku.ca", "p", "visitor", "999", false);
        assertTrue(userUnknown.getPricingStrategy() instanceof PartnerPricingStrategy,
                "Unknown types should fall back to PartnerPricingStrategy.");

        // Case 2: Null string handles gracefully and drops into default
        User userNull = new User("u-6", "null@yorku.ca", "p", null, "000", false);
        assertTrue(userNull.getPricingStrategy() instanceof PartnerPricingStrategy,
                "Null account type should fall back safely to PartnerPricingStrategy.");
    }

    // --- HOURLY RATE & HELPER METHOD TESTS ---

    @Test
    public void testGetHourlyRate_returnsCastIntegerRate() {
        // Student hourly rate is traditionally 0.0 or a low baseline.
        // This confirms the double value maps cleanly to the expected int method return value.
        User user = new User("u-7", "rate@yorku.ca", "p", "student", "111", true);

        int expectedRate = (int) user.getPricingStrategy().getHourlyRate();
        assertEquals(expectedRate, user.getHourlyRate(),
                "getHourlyRate should match the cast integer version of the strategy rate.");
    }

    @Test
    public void testToString_formatsExpectedStringRepresentation() {
        User user = new User("u-99", "admin@yorku.ca", "secret", "staff", "org-55", true);

        String expectedString = "User[u-99 admin@yorku.ca type=staff verified=true]";
        assertEquals(expectedString, user.toString(), "toString format must match the exact defined pattern.");
    }
}
package scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import scheduler.model.User;
import scheduler.strategy.StudentPricingStrategy;
import scheduler.strategy.FacultyPricingStrategy;
import scheduler.strategy.StaffPricingStrategy;
import scheduler.strategy.PartnerPricingStrategy;

public class UserTest {

    @Test
    public void testUserCreationAndGetters() {
        User user = new User("U101", "aleena@yorku.ca", "pass123", "student", "219027945", true);
        assertNotNull(user);
        assertEquals("U101", user.getId());
        assertEquals("aleena@yorku.ca", user.getEmail());
        assertEquals("pass123", user.getPassword());
        assertEquals("student", user.getAccountType());
        assertEquals("219027945", user.getOrgOrStudentId());
        assertTrue(user.isVerified());
    }

    @Test
    public void testStudentPricingStrategyAssignment() {
        User user = new User("U101", "student@yorku.ca", "pass", "Student", "123", true);
        assertTrue(user.getPricingStrategy() instanceof StudentPricingStrategy);
    }

    @Test
    public void testFacultyPricingStrategyAssignment() {
        User user = new User("U102", "prof@yorku.ca", "pass", "FACULTY", "ORG45", true);
        assertTrue(user.getPricingStrategy() instanceof FacultyPricingStrategy);
    }

    @Test
    public void testStaffPricingStrategyAssignment() {
        User user = new User("U103", "staff@yorku.ca", "pass", "staff ", "ORG12", true);
        assertTrue(user.getPricingStrategy() instanceof StaffPricingStrategy);
    }

    @Test
    public void testPartnerPricingStrategyDefaultAssignment() {
        User user = new User("U104", "partner@ext.com", "pass", "partner", "COMP99", false);
        assertTrue(user.getPricingStrategy() instanceof PartnerPricingStrategy);
    }

    @Test
    public void testNullAccountTypeDefaultsToPartnerStrategy() {
        User user = new User("U105", "unknown@domain.com", "pass", null, "NONE", false);
        assertTrue(user.getPricingStrategy() instanceof PartnerPricingStrategy);
    }

    @Test
    public void testUnknownAccountTypeDefaultsToPartnerStrategy() {
        User user = new User("U106", "guest@domain.com", "pass", "guest", "NONE", false);
        assertTrue(user.getPricingStrategy() instanceof PartnerPricingStrategy);
    }

    @Test
    public void testIsVerifiedFalse() {
        User user = new User("U107", "unverified@yorku.ca", "pass", "student", "999", false);
        assertFalse(user.isVerified());
    }

    @Test
    public void testGetHourlyRate() {
        User student = new User("U108", "student@yorku.ca", "pass", "student", "123", true);
        assertEquals((int) student.getPricingStrategy().getHourlyRate(), student.getHourlyRate());
    }

    @Test
    public void testToStringFormat() {
        User user = new User("U109", "test@yorku.ca", "pass", "student", "123", true);
        String expected = "User[U109 test@yorku.ca type=student verified=true]";
        assertEquals(expected, user.toString());
    }
}
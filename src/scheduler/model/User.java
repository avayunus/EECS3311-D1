package scheduler.model;

import scheduler.strategy.PricingStrategy;
import scheduler.strategy.StudentPricingStrategy;
import scheduler.strategy.FacultyPricingStrategy;
import scheduler.strategy.StaffPricingStrategy;
import scheduler.strategy.PartnerPricingStrategy;

/**
 * Account row loaded from users.csv (Req1 account types + verification flag).
 */
public class User {

    private final String id;
    private final String email;
    private final String password;
    private final String accountType;
    private final String orgOrStudentId;
    private final boolean verified;
    private final PricingStrategy pricingStrategy;

    public User(String id, String email, String password, String accountType,
            String orgOrStudentId, boolean verified) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.orgOrStudentId = orgOrStudentId;
        this.verified = verified;

        switch (accountType == null ? "" : accountType.toLowerCase().trim()) {
            case "student":
                this.pricingStrategy = new StudentPricingStrategy();
                break;
            case "faculty":
                this.pricingStrategy = new FacultyPricingStrategy();
                break;
            case "staff":
                this.pricingStrategy = new StaffPricingStrategy();
                break;
            case "partner":
            default:
                this.pricingStrategy = new PartnerPricingStrategy();
                break;
        }

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getOrgOrStudentId() {
        return orgOrStudentId;
    }

    public boolean isVerified() {
        return verified;
    }

    public PricingStrategy getPricingStrategy() {return pricingStrategy;}

    /** Hourly rate from Req3  */
    public int getHourlyRate() {
        return (int) this.pricingStrategy.getHourlyRate();
    }

    @Override
    public String toString() {
        return "User[" + id + " " + email + " type=" + accountType
                + " verified=" + verified + "]";
    }
}

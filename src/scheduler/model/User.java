package scheduler.model;

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

    public User(String id, String email, String password, String accountType,
            String orgOrStudentId, boolean verified) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.orgOrStudentId = orgOrStudentId;
        this.verified = verified;
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

    /** Hourly rate from Req3. */
    public int getHourlyRate() {
        switch (accountType == null ? "" : accountType.toLowerCase()) {
            case "student":
                return 20;
            case "faculty":
                return 30;
            case "staff":
                return 40;
            case "partner":
                return 50;
            default:
                return 50;
        }
    }

    @Override
    public String toString() {
        return "User[" + id + " " + email + " type=" + accountType
                + " verified=" + verified + "]";
    }
}

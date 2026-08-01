package scheduler.data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import scheduler.model.User;

/**
 * CSV-backed user/account store (Req1 registration fields + verification).
 */
public class CsvUserRepository implements IUserRepository {

    private final String path;
    private final List<User> cache = new ArrayList<User>();

    public CsvUserRepository(String path) {
        this.path = path;
        load();
    }

    private void load() {
        cache.clear();
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        CsvReader reader = null;
        try {
            reader = new CsvReader(path);
            reader.readHeaders();
            while (reader.readRecord()) {
                String id = reader.get("id");
                String email = reader.get("email");
                String password = reader.get("password");
                String verifiedRaw = reader.get("verified");

                // Check for null OR empty strings to catch missing columns that return ""
                if (id == null || id.isBlank() ||
                        email == null || email.isBlank() ||
                        password == null || password.isBlank() ||
                        verifiedRaw == null || verifiedRaw.isBlank()) {

                    throw new IllegalArgumentException("Malformed row data: Required CSV columns are missing or blank.");
                }

                User user = new User(
                        id,
                        email,
                        password,
                        reader.get("accountType"),
                        reader.get("orgOrStudentId"),
                        Boolean.parseBoolean(verifiedRaw.trim()));
                cache.add(user);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load users from " + path, e);
        }finally {
            // Enforce file closure to prevent Windows file-locking test teardown crashes!
            if (reader != null) {
                reader.close();
            }
        }
    }

    private void writeAll() {
        try {
            CsvWriter writer = new CsvWriter(new FileWriter(path, false), ',');
            writer.write("id");
            writer.write("email");
            writer.write("password");
            writer.write("accountType");
            writer.write("orgOrStudentId");
            writer.write("verified");
            writer.endRecord();

            for (User user : cache) {
                writer.write(user.getId());
                writer.write(user.getEmail());
                writer.write(user.getPassword());
                writer.write(user.getAccountType());
                writer.write(user.getOrgOrStudentId());
                writer.write(String.valueOf(user.isVerified()));
                writer.endRecord();
            }
            writer.close();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to write users to " + path, e);
        }
    }

    private boolean removeFromCache(String id) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).getId().equals(id)) {
                cache.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(cache);
    }

    @Override
    public User findById(String id) {
        for (User user : cache) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        if (email == null) {
            return null;
        }
        for (User user : cache) {
            if (email.equalsIgnoreCase(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {
        if (user == null) {
            return;
        }
        removeFromCache(user.getId());
        cache.add(user);
        writeAll();
    }
}

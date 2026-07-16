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
        try {
            CsvReader reader = new CsvReader(path);
            reader.readHeaders();
            while (reader.readRecord()) {
                User user = new User(
                        reader.get("id"),
                        reader.get("email"),
                        reader.get("password"),
                        reader.get("accountType"),
                        reader.get("orgOrStudentId"),
                        Boolean.parseBoolean(reader.get("verified").trim()));
                cache.add(user);
            }
            reader.close();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load users from " + path, e);
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

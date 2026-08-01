package scheduler.booking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import scheduler.data.CsvUserRepository;
import scheduler.model.User;

public class CsvUserRepositoryTest {

    @TempDir
    public File tempFolder;

    private File tempCsvFile;
    private CsvUserRepository repository;

    @BeforeEach
    public void setUp() throws IOException {
        tempCsvFile = new File(tempFolder, "users_cache.csv");
        // Seed an empty valid CSV file with correct headers so the constructor runs safely during setup
        writeRawCsv("id,email,password,accountType,orgOrStudentId,verified\n");
        repository = new CsvUserRepository(tempCsvFile.getAbsolutePath());
    }

    private void writeRawCsv(String content) throws IOException {
        try (FileWriter fw = new FileWriter(tempCsvFile)) {
            fw.write(content);
        }
    }

    // --- CONSTRUCTOR & LOAD BRANCH TESTS ---

    @Test
    public void testConstructor_fileDoesNotExist() {
        File missingFile = new File(tempFolder, "missing_users.csv");
        // Should execute cleanly without breaking or throwing an exception
        CsvUserRepository repo = new CsvUserRepository(missingFile.getAbsolutePath());
        assertTrue(repo.findAll().isEmpty(), "Repository cache should be empty if file does not exist.");
    }

    @Test
    public void testLoad_parsesValidUserData() throws IOException {
        writeRawCsv("id,email,password,accountType,orgOrStudentId,verified\n" +
                "u-1,test@yorku.ca,pass123,student,219000000, true \n");

        CsvUserRepository repo = new CsvUserRepository(tempCsvFile.getAbsolutePath());
        List<User> users = repo.findAll();

        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals("u-1", user.getId());
        assertEquals("test@yorku.ca", user.getEmail());
        assertEquals("pass123", user.getPassword());
        assertEquals("student", user.getAccountType());
        assertEquals("219000000", user.getOrgOrStudentId());
        assertTrue(user.isVerified(), "Verified boolean flag should be parsed and trimmed successfully.");
    }

    @Test
    public void testLoad_throwsExceptionOnMalformedData() throws IOException {
        // Create an alternate separate file to avoid blocking file-teardown hooks if a handle leaks on exception
        File errorFile = new File(tempFolder, "malformed_users.csv");
        try (FileWriter fw = new FileWriter(errorFile)) {
            // Missing a required field like password/verified entirely to cause lower-level framework failure
            fw.write("id,email\n" +
                    "u-err,bad@yorku.ca\n");
        }

        assertThrows(IllegalStateException.class, () -> {
            new CsvUserRepository(errorFile.getAbsolutePath());
        }, "Should catch framework exceptions and map them to an IllegalStateException wrap.");
    }

    // --- LOOKUP & ENCAPSULATION TESTS ---

    @Test
    public void testFindAll_returnsDefensiveCopy() {
        User user = new User("u-10", "user10@yorku.ca", "p10", "faculty", "org-10", false);
        repository.save(user);

        List<User> snapshot1 = repository.findAll();
        List<User> snapshot2 = repository.findAll();

        assertNotSame(snapshot1, snapshot2, "findAll must generate a new memory array list instance pointer.");
        assertEquals(1, snapshot1.size());
    }

    @Test
    public void testFindById_returnsCorrectUserOrNull() {
        User target = new User("target-id", "find@yorku.ca", "p", "staff", "org-5", true);
        repository.save(target);

        assertEquals(target, repository.findById("target-id"));
        assertNull(repository.findById("non-existent-id"), "Should return null if the user ID is missing from the cache.");
    }

    @Test
    public void testFindByEmail_handlesNullAndCaseInsensitivity() {
        User target = new User("u-2", "ALICE@yorku.ca", "p2", "student", "123", true);
        repository.save(target);

        // Branch 1: Null verification check
        assertNull(repository.findByEmail(null), "Passing null email should return null immediately.");

        // Branch 2: Exact matching
        assertEquals(target, repository.findByEmail("ALICE@yorku.ca"));

        // Branch 3: Case-insensitive matching verification
        assertEquals(target, repository.findByEmail("alice@yorku.ca"), "Lookup must be case-insensitive.");

        // Branch 4: Missing email verification
        assertNull(repository.findByEmail("bob@yorku.ca"), "Should return null for non-existent emails.");
    }

    // --- SAVE TESTS ---

    @Test
    public void testSave_nullUserDoesNothing() {
        repository.save(null);
        assertTrue(repository.findAll().isEmpty(), "Saving a null user should short circuit without execution.");
    }

    @Test
    public void testSave_insertsNewRecordAndWritesToDisk() throws IOException {
        User newUser = new User("u-new", "new@yorku.ca", "secure", "partner", "org-99", false);
        repository.save(newUser);

        assertEquals(1, repository.findAll().size());

        List<String> lines = Files.readAllLines(tempCsvFile.toPath());
        assertTrue(lines.contains("u-new,new@yorku.ca,secure,partner,org-99,false"),
                "The user data metrics should write accurately to the target plain text file.");
    }

    @Test
    public void testSave_updatesExistingRecordWithoutDuplicates() {
        User initial = new User("u-unique", "old@yorku.ca", "oldpass", "student", "111", false);
        repository.save(initial);

        // Update details keeping the identical user ID string value intact
        User updated = new User("u-unique", "new_email@yorku.ca", "newpass", "staff", "222", true);
        repository.save(updated);

        List<User> currentCache = repository.findAll();
        assertEquals(1, currentCache.size(), "Cache replacement logic must prevent expanding the list structure with duplicate keys.");
        assertEquals("new_email@yorku.ca", currentCache.get(0).getEmail());
        assertEquals("newpass", currentCache.get(0).getPassword());
        assertEquals("staff", currentCache.get(0).getAccountType());
        assertTrue(currentCache.get(0).isVerified());
    }
}
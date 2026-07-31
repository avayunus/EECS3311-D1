package scheduler.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import scheduler.data.CsvUserRepository;
import scheduler.model.User;

public class CsvUserRepositoryTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File testCsvFile;
    private CsvUserRepository repository;

    @Before
    public void setUp() throws IOException {
        testCsvFile = tempFolder.newFile("test_users.csv");
        repository = new CsvUserRepository(testCsvFile.getAbsolutePath());
    }

    @Test
    public void testLoadNonExistentFileReturnsEmptyList() {
        CsvUserRepository repo = new CsvUserRepository("non_existent_users.csv");
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    public void testSaveAndFindAll() {
        User user = new User("U100", "user@yorku.ca", "pass", "student", "219000000", true);
        repository.save(user);

        List<User> users = repository.findAll();
        assertEquals(1, users.size());
        assertEquals("U100", users.get(0).getId());
    }

    @Test
    public void testFindByIdValid() {
        User user = new User("U101", "user101@yorku.ca", "pass", "student", "219000001", true);
        repository.save(user);

        User found = repository.findById("U101");
        assertNotNull(found);
        assertEquals("user101@yorku.ca", found.getEmail());
    }

    @Test
    public void testFindByIdNonExistentReturnsNull() {
        User found = repository.findById("NON_EXISTENT");
        assertNull(found);
    }

    @Test
    public void testFindByEmailValidCaseInsensitive() {
        User user = new User("U102", "Aleena@yorku.ca", "pass", "student", "219000002", true);
        repository.save(user);

        User found = repository.findByEmail("aleena@yorku.ca");
        assertNotNull(found);
        assertEquals("U102", found.getId());
    }

    @Test
    public void testFindByEmailNullReturnsNull() {
        assertNull(repository.findByEmail(null));
    }

    @Test
    public void testSaveNullUserDoesNothing() {
        repository.save(null);
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    public void testSaveUpdateExistingUser() {
        User u1 = new User("U100", "old@yorku.ca", "pass1", "student", "111", false);
        repository.save(u1);

        User u2 = new User("U100", "new@yorku.ca", "pass2", "faculty", "222", true);
        repository.save(u2);

        List<User> users = repository.findAll();
        assertEquals(1, users.size());
        assertEquals("new@yorku.ca", users.get(0).getEmail());
        assertTrue(users.get(0).isVerified());
    }

    @Test
    public void testLoadUsersFromCsv() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,email,password,accountType,orgOrStudentId,verified\n");
            writer.write("U300,test@yorku.ca,secret,staff,ORG_99,true\n");
        }

        CsvUserRepository repo = new CsvUserRepository(testCsvFile.getAbsolutePath());
        User loaded = repo.findById("U300");
        assertNotNull(loaded);
        assertEquals("test@yorku.ca", loaded.getEmail());
        assertTrue(loaded.isVerified());
    }

    @Test
    public void testFindAllReturnsCopyOfCache() {
        User user = new User("U100", "user@yorku.ca", "pass", "student", "219000000", true);
        repository.save(user);

        List<User> copy1 = repository.findAll();
        copy1.clear();

        List<User> copy2 = repository.findAll();
        assertEquals(1, copy2.size());
    }
}
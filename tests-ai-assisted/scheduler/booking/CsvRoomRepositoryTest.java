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

import scheduler.data.CsvRoomRepository;
import scheduler.model.Room;

public class CsvRoomRepositoryTest {

    @TempDir
    public File tempFolder;

    private File tempCsvFile;
    private CsvRoomRepository repository;

    @BeforeEach
    public void setUp() throws IOException {
        tempCsvFile = new File(tempFolder, "rooms_cache.csv");
        // Seed an empty valid CSV file with correct headers so the constructor runs safely during setup
        writeRawCsv("id,name,capacity,building,status\n");
        repository = new CsvRoomRepository(tempCsvFile.getAbsolutePath());
    }

    private void writeRawCsv(String content) throws IOException {
        try (FileWriter fw = new FileWriter(tempCsvFile)) {
            fw.write(content);
        }
    }

    // --- CONSTRUCTOR & LOAD BRANCH TESTS ---

    @Test
    public void testConstructor_fileDoesNotExist() {
        File missingFile = new File(tempFolder, "missing_rooms.csv");
        // Should execute cleanly without breaking or throwing an exception
        CsvRoomRepository repo = new CsvRoomRepository(missingFile.getAbsolutePath());
        assertTrue(repo.findAll().isEmpty(), "Repository cache should be empty if file does not exist.");
    }

    @Test
    public void testLoad_parsesValidRoomData() throws IOException {
        writeRawCsv("id,name,capacity,building,status\n" +
                "r-1,Lecture Hall A, 120 , Lassonde , MAINTENANCE \n");

        CsvRoomRepository repo = new CsvRoomRepository(tempCsvFile.getAbsolutePath());
        List<Room> rooms = repo.findAll();

        assertEquals(1, rooms.size());
        Room room = rooms.get(0);
        assertEquals("r-1", room.getId());
        assertEquals("Lecture Hall A", room.getName());
        assertEquals(120, room.getCapacity());
        assertEquals("Lassonde", room.getBuilding());
        assertEquals("MAINTENANCE", room.getStatus(), "Status should be cleanly trimmed.");
    }

    @Test
    public void testLoad_defaultsEmptyOrMissingStatusToAvailable() throws IOException {
        writeRawCsv("id,name,capacity,building,status\n" +
                "r-2,Lab B,40,Bergeron,\n" +
                "r-3,Lab C,30,Bergeron,   \n");

        CsvRoomRepository repo = new CsvRoomRepository(tempCsvFile.getAbsolutePath());

        Room roomBlank = repo.findById("r-2");
        assertNotNull(roomBlank);
        assertEquals("AVAILABLE", roomBlank.getStatus(), "An empty status cell should map to AVAILABLE.");

        Room roomSpaces = repo.findById("r-3");
        assertNotNull(roomSpaces);
        assertEquals("AVAILABLE", roomSpaces.getStatus(), "A whitespace-only status cell should map to AVAILABLE.");
    }

    @Test
    public void testLoad_throwsExceptionOnMalformedData() throws IOException {
        // Create an alternate separate file to avoid blocking file-teardown hooks if file handle leaks on exception
        File errorFile = new File(tempFolder, "malformed_rooms.csv");
        try (FileWriter fw = new FileWriter(errorFile)) {
            fw.write("id,name,capacity,building,status\n" +
                    "r-err,Broken Room,twelve,Lassonde,AVAILABLE\n");
        }

        assertThrows(IllegalStateException.class, () -> {
            new CsvRoomRepository(errorFile.getAbsolutePath());
        }, "Should catch NumberFormatException when capacity isn't an integer and map to IllegalStateException.");
    }

    // --- FIND ALL & FIND BY ID TESTS ---

    @Test
    public void testFindAll_returnsDefensiveCopy() {
        Room room = new Room("r-10", "Room 10", 15, "Steacie", "AVAILABLE");
        repository.save(room);

        List<Room> snapshot1 = repository.findAll();
        List<Room> snapshot2 = repository.findAll();

        assertNotSame(snapshot1, snapshot2, "findAll must generate a new memory array list instance pointer.");
        assertEquals(1, snapshot1.size());
    }

    @Test
    public void testFindById_returnsCorrectRoomOrNull() {
        Room target = new Room("target-id", "Target Room", 50, "Lassonde", "AVAILABLE");
        repository.save(target);

        assertEquals(target, repository.findById("target-id"));
        assertNull(repository.findById("non-existent-id"), "Should return null gracefully if room is missing from cache.");
    }

    // --- SAVE TESTS ---

    @Test
    public void testSave_nullRoomDoesNothing() {
        repository.save(null);
        assertTrue(repository.findAll().isEmpty(), "Saving null should safely short circuit.");
    }

    @Test
    public void testSave_insertsNewRecordAndWritesToDisk() throws IOException {
        Room newRoom = new Room("r-new", "New Space", 25, "Life Sciences", "AVAILABLE");
        repository.save(newRoom);

        assertEquals(1, repository.findAll().size());

        List<String> lines = Files.readAllLines(tempCsvFile.toPath());
        assertTrue(lines.contains("r-new,New Space,25,Life Sciences,AVAILABLE"), "The data values should write accurately to the file.");
    }

    @Test
    public void testSave_updatesExistingRecordWithoutDuplicates() {
        Room initial = new Room("r-unique", "Old Name", 10, "Steacie", "AVAILABLE");
        repository.save(initial);

        // Update name and capacity for the identical room ID string
        Room updated = new Room("r-unique", "New Name", 20, "Steacie", "OCCUPIED");
        repository.save(updated);

        List<Room> currentCache = repository.findAll();
        assertEquals(1, currentCache.size(), "Cache replacement should avoid adding structural duplicates.");
        assertEquals("New Name", currentCache.get(0).getName());
        assertEquals(20, currentCache.get(0).getCapacity());
        assertEquals("OCCUPIED", currentCache.get(0).getStatus());
    }
}
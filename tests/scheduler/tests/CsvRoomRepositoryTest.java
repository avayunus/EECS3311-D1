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

import scheduler.data.CsvRoomRepository;
import scheduler.model.Room;

public class CsvRoomRepositoryTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File testCsvFile;
    private CsvRoomRepository repository;

    @Before
    public void setUp() throws IOException {
        testCsvFile = tempFolder.newFile("test_rooms.csv");
        repository = new CsvRoomRepository(testCsvFile.getAbsolutePath());
    }

    @Test
    public void testLoadNonExistentFileReturnsEmptyList() {
        CsvRoomRepository repo = new CsvRoomRepository("non_existent_rooms.csv");
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    public void testSaveAndFindAll() {
        Room room = new Room("R101", "Lassonde 1001", 40, "Lassonde", "AVAILABLE");
        repository.save(room);

        List<Room> rooms = repository.findAll();
        assertEquals(1, rooms.size());
        assertEquals("R101", rooms.get(0).getId());
    }

    @Test
    public void testFindByIdValid() {
        Room room = new Room("R102", "Bergeron 2002", 25, "Bergeron", "AVAILABLE");
        repository.save(room);

        Room found = repository.findById("R102");
        assertNotNull(found);
        assertEquals("Bergeron 2002", found.getName());
    }

    @Test
    public void testFindByIdNonExistentReturnsNull() {
        Room found = repository.findById("NON_EXISTENT");
        assertNull(found);
    }

    @Test
    public void testSaveNullRoomDoesNothing() {
        repository.save(null);
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    public void testSaveUpdateExistingRoom() {
        Room r1 = new Room("R101", "Old Name", 20, "Lassonde", "AVAILABLE");
        repository.save(r1);

        Room r2 = new Room("R101", "New Name", 30, "Lassonde", "MAINTENANCE");
        repository.save(r2);

        List<Room> rooms = repository.findAll();
        assertEquals(1, rooms.size());
        assertEquals("New Name", rooms.get(0).getName());
        assertEquals(30, rooms.get(0).getCapacity());
        assertEquals("MAINTENANCE", rooms.get(0).getStatus());
    }

    @Test
    public void testLoadRoomsFromCsvWithDefaultStatus() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,name,capacity,building,status\n");
            writer.write("R200,Lab 200,15,Steacie,\n");
        }

        CsvRoomRepository repo = new CsvRoomRepository(testCsvFile.getAbsolutePath());
        Room loaded = repo.findById("R200");
        assertNotNull(loaded);
        assertEquals("AVAILABLE", loaded.getStatus());
    }

    @Test
    public void testLoadRoomsFromCsvWithSpecifiedStatus() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,name,capacity,building,status\n");
            writer.write("R300,Lab 300,50,Vari Hall,DISABLED\n");
        }

        CsvRoomRepository repo = new CsvRoomRepository(testCsvFile.getAbsolutePath());
        Room loaded = repo.findById("R300");
        assertNotNull(loaded);
        assertEquals("DISABLED", loaded.getStatus());
    }

    @Test(expected = IllegalStateException.class)
    public void testLoadCorruptedCapacityThrowsException() throws IOException {
        try (FileWriter writer = new FileWriter(testCsvFile)) {
            writer.write("id,name,capacity,building,status\n");
            writer.write("R400,Lab 400,INVALID,Vari Hall,AVAILABLE\n");
        }
        new CsvRoomRepository(testCsvFile.getAbsolutePath());
    }

    @Test
    public void testFindAllReturnsCopyOfCache() {
        Room room = new Room("R101", "Lassonde 1001", 40, "Lassonde", "AVAILABLE");
        repository.save(room);

        List<Room> copy1 = repository.findAll();
        copy1.clear();

        List<Room> copy2 = repository.findAll();
        assertEquals(1, copy2.size());
    }
}
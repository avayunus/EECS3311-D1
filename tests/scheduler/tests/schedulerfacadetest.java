package scheduler.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import scheduler.data.IRoomRepository;
import scheduler.data.IUserRepository;
import scheduler.data.InMemoryBookingRepository;
import scheduler.facade.SchedulerFacade;
import scheduler.model.Room;
import scheduler.model.TimeSlot;
import scheduler.model.User;
import scheduler.rules.NoOverlapRule;

public class schedulerfacadetest {

    private SchedulerFacade facade;
    private FakeRoomRepo rooms;
    private FakeUserRepo users;

    @Before
    public void setUp() {
        // build fake repos with a couple of rooms and users so i dont need
        rooms = new FakeRoomRepo();
        rooms.save(new Room("LAS1004", "Seminar Room A", 12, "Lassonde", "AVAILABLE"));
        rooms.save(new Room("LAS1007", "Lounge", 12, "Lassonde", "MAINTENANCE"));

        users = new FakeUserRepo();
        users.save(new User("ayunus", "ayunus@yorku.ca", "pw", "faculty", "123", true));

        facade = new SchedulerFacade(rooms, users);
        // start wires the singleton with a fresh empty booking repo each time
        facade.start(new InMemoryBookingRepository(), new NoOverlapRule());
    }

    // my own fake room repo, just holds a list in memory
    private static class FakeRoomRepo implements IRoomRepository {
        private List<Room> list = new ArrayList<Room>();

        public List<Room> findAll() {
            return list;
        }

        public Room findById(String id) {
            for (Room r : list) {
                if (r.getId().equals(id)) {
                    return r;
                }
            	}
            return null;
        }

        public void save(Room room) {
            list.add(room);
        }
    }

    // same idea for users
    private static class FakeUserRepo implements IUserRepository {
         private List<User> list = new ArrayList<User>();

        public List<User> findAll() {
            return list;
        }

        public User findById(String id) {
            for (User u : list) {
                if (u.getId().equals(id)) {
                    return u;
                }
            }
            return null;
        }

        public User findByEmail(String email) {
            for (User u : list) {
                if (u.getEmail().equals(email)) {
                    return u;
                }
             }
            return null;
        }

        public void save(User user) {
            list.add(user);
        }
    }

    @Test
    public void requestBookingWorksForAvailableRoom() {
        Room room = rooms.findById("LAS1004");
        boolean ok = facade.requestBooking(room, new TimeSlot(9, 10), "ayunus", null);
        assertTrue(ok);
        assertEquals(1, facade.getBookings().size());
    }

    @Test
    public void requestBookingFailsForNullRoom() {
        // no room means it should just say no
        boolean ok = facade.requestBooking((Room) null, new TimeSlot(9, 10), "ayunus", null);
        assertFalse(ok);
    }

    @Test
    public void requestBookingFailsForNullSlot() {
        Room room = rooms.findById("LAS1004");
        boolean ok = facade.requestBooking(room, null, "ayunus", null);
        assertFalse(ok);
    }

    @Test
    	public void requestBookingFailsForBlankUser() {
          // empty user id shouldnt be allowed to book
        Room room = rooms.findById("LAS1004");
         boolean ok = facade.requestBooking(room, new TimeSlot(9, 10), "  ", null);
        assertFalse(ok);
    }

    @Test
    public void requestBookingFailsForUnknownRoom() {
        // this room isnt in the repo so the facade cant confirm it
        Room ghost = new Room("NOPE999", "Fake", 5, "Nowhere", "AVAILABLE");
        boolean ok = facade.requestBooking(ghost, new TimeSlot(9, 10), "ayunus", null);
        assertFalse(ok);
    }

    @Test
    public void requestBookingFailsForRoomUnderMaintenance() {
        // lounge is set to maintenance so it isnt bookable
        Room room = rooms.findById("LAS1007");
        boolean ok = facade.requestBooking(room, new TimeSlot(9, 10), "ayunus", null);
        assertFalse(ok);
    }

    @Test
    public void requestBookingByRoomIdWorks() {
        // the overload that just takes the room id string
         boolean ok = facade.requestBooking("LAS1004", new TimeSlot(13, 14), "ayunus", null);
        assertTrue(ok);
    }

    @Test
    public void requestBookingByUnknownRoomIdFails() {
        boolean ok = facade.requestBooking("DOESNOTEXIST", new TimeSlot(13, 14), "ayunus", null);
        assertFalse(ok);
    }

    @Test
    public void cancelBookingRemovesIt() {
        facade.requestBooking("LAS1004", new TimeSlot(9, 10), "ayunus", null);
        // grab the id of the booking that just got made
        String id = facade.getBookings().get(0).getId();
        assertTrue(facade.cancelBooking(id));
        assertNull(facade.findBooking(id));
    }

    @Test
    public void getRoomsReturnsWhatIsInTheRepo() {
        // i put two rooms in during setup
        assertEquals(2, facade.getRooms().size());
    }

    @Test
    public void findRoomWorksAndReturnsNullWhenMissing() {
        assertNotNull(facade.findRoom("LAS1004"));
        assertNull(facade.findRoom("NOPE999"));
    }

    @Test
    public void findUserAndFindUserByEmailWork() {
        assertNotNull(facade.findUser("ayunus"));
        assertNotNull(facade.findUserByEmail("ayunus@yorku.ca"));
        assertNull(facade.findUser("nobody"));
    }
}
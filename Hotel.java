
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private List<RoomType> roomTypes;
    private List<Reservation> reservations;
    private List<Guest> guests;

    public Hotel(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: Hotel name cannot be empty.");
        }
        this.name = name;
        this.rooms = new ArrayList<>();
        this.roomTypes = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    public void addRoomType(RoomType type) {
        if (type != null) roomTypes.add(type);
    }

    public void addRoom(Room room) {
        if (room != null) rooms.add(room);
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
    
    public void addGuest(Guest guest) {
        if (guest != null) guests.add(guest);
    }
    
    public List<Guest> getGuests() {
        return guests;
    }
    
    // Checks if we have enough physical rooms of this type
    public boolean isTypeAvailable(RoomType type, int quantityNeeded) {
        int count = 0;
        for (Room r : rooms) {
            if (r.getRoomType().equals(type) && r.isFree()) {
                count++;
            }
        }
        return count >= quantityNeeded;
    }

    public Reservation createReservation(LocalDate start, LocalDate end, ReservePayer payer) {
        int newId = reservations.size() + 100;
        Reservation res = new Reservation(newId, start, end, payer);
        reservations.add(res);
        return res;
    }
    
    public String getName() {
        return name;
    }
}
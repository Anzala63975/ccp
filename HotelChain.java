import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelChain {
    private String name;
    private List<Hotel> hotels;

    public HotelChain(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: Hotel Chain name cannot be empty.");
        }
        this.name = name;
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        if (hotel != null) {
            hotels.add(hotel);
        }
    }
    
    public String getName() {
        return name;
    }

    // Controller Methods (Connects to Hotel/Room)

    public Reservation makeReservation(String hotelName, LocalDate start, LocalDate end, ReservePayer payer, RoomType type, int count) {
        Hotel hotel = findHotel(hotelName);
        if (hotel == null) throw new IllegalArgumentException("Error: Hotel not found.");

        if (!hotel.isTypeAvailable(type, count)) {
            throw new IllegalStateException("Error: Not enough rooms available.");
        }

        Reservation res = hotel.createReservation(start, end, payer);
        res.addRoomRequirement(type, count);
        return res;
    }

    public void checkInGuest(String hotelName, int roomNumber, Guest guest) {
        Room room = findRoom(hotelName, roomNumber);
        if (room == null) throw new IllegalArgumentException("Error: Room not found.");
        
        room.checkInGuest(guest);
    }

    public void checkOutGuest(String hotelName, int roomNumber) {
        Room room = findRoom(hotelName, roomNumber);
        if (room == null) throw new IllegalArgumentException("Error: Room not found.");
        
        room.checkOutGuest();
    }

    public void cancelReservation(String hotelName, int roomNumber) {
        Room room = findRoom(hotelName, roomNumber);
        if (room == null) throw new IllegalArgumentException("Error: Room not found.");
        
        room.cancelReservation();
    }

    // Helper Methods to Find Objects

    private Hotel findHotel(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equalsIgnoreCase(name)) return h;
        }
        return null;
    }

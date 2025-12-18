import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("# HOTEL RESERVATION SYSTEM STARTING #");

        // 1. Setup Data
        HotelChain chain = new HotelChain("Global Hotels");
        Hotel hotel = new Hotel("City Branch");
        
        // Add Room Types
        RoomType single = new RoomType("Single", 50.0);
        RoomType doubl = new RoomType("Double", 100.0);
        hotel.addRoomType(single);
        hotel.addRoomType(doubl);

        // Add 5 Rooms
        hotel.addRoom(new Room(101, single));
        hotel.addRoom(new Room(102, single));
        hotel.addRoom(new Room(201, doubl));
        hotel.addRoom(new Room(202, doubl));
        
        chain.addHotel(hotel);
        System.out.println(">> System initialized with Hotel: " + hotel.getName());

        // 2. Create Guest & Payer
        Guest guest = new Guest("Momal Rana", "Karachi, PK");
        ReservePayer payer = new ReservePayer("1234-5678-9012-3456", "ID-999");
        System.out.println(">> Guest Created: " + guest.getName());

        // 3. Make a Reservation
        System.out.println("\n>> Attempting to book a Single Room...");
        try {
            LocalDate start = LocalDate.now();
            LocalDate end = LocalDate.now().plusDays(3);
            
            Reservation res = chain.makeReservation("City Branch", start, end, payer, single, 1);
            System.out.println("SUCCESS! Reservation Created. ID: " + res.getNumber());
        } catch (Exception e) {
            System.out.println("FAILED: " + e.getMessage());
        }

        // 4. Check In
        System.out.println("\n>> Guest Checking In to Room 101...");
        try {
            chain.checkInGuest("City Branch", 101, guest);
            System.out.println("SUCCESS! Guest is now in Room 101.");
        } catch (Exception e) {
            System.out.println("Check-in Failed: " + e.getMessage());
        }

        System.out.println("\n# SIMULATION COMPLETE #");
    }
}
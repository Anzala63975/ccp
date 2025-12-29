package HotelSystem;

public class Room {
    private int roomNumber;
    private RoomType roomType;
    private String status; // FREE, RESERVED, OCCUPIED
    private Guest guest;
    private Reservation reservation;

    public Room(int roomNumber, RoomType roomType) {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Error: Room number must be positive.");
        }
        if (roomType == null) {
            throw new IllegalArgumentException("Error: Room type cannot be null.");
        }
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = "FREE";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isFree() {
        return "FREE".equals(status);
    }

    public void checkInGuest(Guest guest) {
        if (!"RESERVED".equals(status)) {
            throw new IllegalStateException("Error: Room must be reserved before check-in.");
        }
        if (guest == null) {
            throw new IllegalArgumentException("Error: Guest cannot be null.");
        }
        this.guest = guest;
        this.status = "OCCUPIED";
    }

    public void checkOutGuest() {
        if (!"OCCUPIED".equals(status)) {
            throw new IllegalStateException("Error: Room must be occupied before check-out.");
        }
        this.guest = null;
        this.status = "FREE";
    }

    public void cancelReservation() {
        if (!"RESERVED".equals(status)) {
            throw new IllegalStateException("Error: Room must be reserved to cancel.");
        }
        this.reservation = null;
        this.status = "FREE";
    }

    // Additional methods if needed
    public void reserve(Reservation reservation) {
        if (!isFree()) {
            throw new IllegalStateException("Error: Room is not free.");
        }
        this.reservation = reservation;
        this.status = "RESERVED";
    }
}
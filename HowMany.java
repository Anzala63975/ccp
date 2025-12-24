public class HowMany {
    private int number;
    private RoomType roomType;

    public HowMany(int number, RoomType roomType) {
        if (number <= 0) {
            throw new IllegalArgumentException("Error: Quantity must be positive.");
        }
        if (roomType == null) {
            throw new IllegalArgumentException("Error: RoomType cannot be null.");
        }
        this.number = number;
        this.roomType = roomType;
    }

    public int getNumber() {
        return number;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservePayer payer;
    private List<RoomRequirement> requirements;

    public Reservation(int id, LocalDate startDate, LocalDate endDate, ReservePayer payer) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Error: Dates cannot be null.");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Error: Start date cannot be after end date.");
        }
        if (payer == null) {
            throw new IllegalArgumentException("Error: Payer cannot be null.");
        }
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payer = payer;
        this.requirements = new ArrayList<>();
    }

    public void addRoomRequirement(RoomType type, int count) {
        if (type == null || count <= 0) {
            throw new IllegalArgumentException("Error: Invalid room requirement.");
        }
        requirements.add(new RoomRequirement(type, count));
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ReservePayer getPayer() {
        return payer;
    }

    public List<RoomRequirement> getRequirements() {
        return requirements;
    }

    // Inner class for room requirements
    public static class RoomRequirement {
        private RoomType type;
        private int count;

        public RoomRequirement(RoomType type, int count) {
            this.type = type;
            this.count = count;
        }

        public RoomType getType() {
            return type;
        }

        public int getCount() {
            return count;
        }
    }
}

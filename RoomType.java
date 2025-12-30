
public class RoomType {
    private String name;
    private double cost;

    public RoomType(String name, double cost) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Room type name cannot be empty.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Error: Cost cannot be negative.");
        }
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
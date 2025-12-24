
public class Guest {
    private String name;
    private String addressDetails;

    public Guest(String name, String addressDetails) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Guest name cannot be empty.");
        }
        if (addressDetails == null || addressDetails.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Address cannot be empty.");
        }
        this.name = name;
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }
}
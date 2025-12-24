public class ReservePayer {
    private String creditCardDetails;
    private String id;

    public ReservePayer(String creditCardDetails, String id) {
        if (creditCardDetails == null || creditCardDetails.length() < 10) {
            // Simple validation: assuming CC must be at least 10 chars
            throw new IllegalArgumentException("Error: Invalid credit card details.");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Error: ID cannot be empty.");
        }
        this.creditCardDetails = creditCardDetails;
        this.id = id;
    }

    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    public String getId() {
        return id;
    }
} 

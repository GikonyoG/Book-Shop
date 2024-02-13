public class User {
    private int id;
    private String username;
    private String surname;
    private int houseNumber;
    private String postcode;
    private String city;
    private double balance;
    private String role;

    
    
    private String fullAddress;

    

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}

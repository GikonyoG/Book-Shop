import java.io.*;
import java.util.*;
public class UserAccount {
    private String username;
    private String role;
    private double balance;  
    private String fullAddress;

    public UserAccount(String username, String role, double balance) {
        this.username = username;
        this.role = role;
        this.balance = balance;  
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    
    public double getBalance() {
        return balance;
    }
   

    public String getFullAddress() {
        return fullAddress;
    }

    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void updateBalance(double amount) {
        this.balance -= amount;
    }
 
    public static List<UserAccount> readUserAccountsFromFile(String filename) {
        List<UserAccount> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[1].trim();  
                String role = parts[7].trim();  
                double balance = 0.0;  
                if (!parts[6].trim().isEmpty()) {  
                    balance = Double.parseDouble(parts[6].trim());  
                }
                users.add(new UserAccount(username, role, balance));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return users;
    }


   
    public static void writeUserAccountsToFile(List<UserAccount> users, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (UserAccount user : users) {
                pw.println(user.getUsername() + "," + user.getRole() + "," + user.getBalance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

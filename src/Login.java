import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
	public static List<UserAccount> readUserAccountsFromFile(String filename) {
	    List<UserAccount> userAccounts = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split(",");
	            String username = parts[2].trim();
	            String role = parts[7].trim();
	            double balance;
	            if(parts[6].trim().isEmpty()) {
	                balance = 0.0;  
	            } else {
	                balance = Double.parseDouble(parts[6].trim());  
	            }
	            userAccounts.add(new UserAccount(username, role, balance));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return userAccounts;
	}


}

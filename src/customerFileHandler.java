import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class customerFileHandler {
    public static List<Books> readBooksFromFile(String filename) {
        List<Books> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                long barcode = Long.parseLong(parts[0].trim());
                String bookType = parts[1].trim();
                String title = parts[2].trim();
                String language = parts[3].trim();
                String genre = parts[4].trim();
                String releaseDate = parts[5].trim();
                int stock = Integer.parseInt(parts[6].trim());
                double price = Double.parseDouble(parts[7].trim());
                
                switch (bookType.toLowerCase()) {
                    case "paperback":
                        int numberOfPages = Integer.parseInt(parts[8].trim());
                        String condition = parts[9].trim();
                        books.add(new Paperback(barcode, title, language, genre, releaseDate, (int) stock, price, numberOfPages, condition));
                        break;
                    case "audiobook":
                        double listeningLength = Double.parseDouble(parts[8].trim());
                        String format = parts[9].trim();
                        books.add(new Audiobook(barcode, title, language, genre, releaseDate, stock, price, listeningLength, format));
                        break;
                    case "ebook":
                        numberOfPages = Integer.parseInt(parts[8].trim());
                        format = parts[9].trim();
                        books.add(new Ebook(barcode, title, language, genre, releaseDate, stock, price, numberOfPages, format));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
    public static void writeUserAccountsToFile(List<UserAccount> userAccounts, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (UserAccount userAccount : userAccounts) {
                writer.println(userAccount.getUsername() + "," + userAccount.getRole() + "," + userAccount.getBalance());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Books {
    protected long barcode;
    protected String bookType;
    protected String title;
    protected String language;
    protected String genre;
    protected String releaseDate;
    protected int stock;
    protected double price;

    // common constructor for all book types
    public Books(long barcode, String bookType, String title, String language,
                String genre, String releaseDate,int stock, double price) {
        this.barcode = barcode;
        this.bookType = bookType;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public long getBarcode() {
        return barcode;
    }
    public String getBookType() {
        return bookType;
    }
    public String getTitle() {
        return title;
    }
    public String getLanguage() {
        return language;
    }
    public String getGenre() {
        return genre;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public double getPrice() {
        return price;
    }
    public void setStock(int d) {
        this.stock = d;
    }


    public static List<Books> loadBooksFromFile(String filename) {
        List<Books> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println(parts);
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
                        books.add(new Paperback(barcode, title, language, genre, releaseDate, stock, price, numberOfPages, condition));
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
    public static void writeBooksToFile(List<Books> books, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Books book : books) {
                bw.write(book.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toFileString() {
        return barcode + "," + bookType+ "," + title + "," + language + "," + genre + "," + releaseDate + "," + stock + "," + price;
    }

}

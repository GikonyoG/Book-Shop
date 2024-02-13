
public class Paperback extends Books {
    private int numberOfPages;
    private String condition;

    public Paperback(long barcode, String title, String language, String genre,
                     String releaseDate, int stock, double price, int numberOfPages, String condition) {
        super(barcode, "paperback", title, language, genre, releaseDate, stock, price);
        this.numberOfPages = numberOfPages;
        this.condition = condition;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getCondition() {
        return condition;
    }
    @Override
    public String toString() {
        return getBarcode() + ", " + 
        		getBookType() + ", " + 
               getTitle() + ", " + 
               getLanguage() + ", " + 
               getGenre() + ", " + 
               getReleaseDate() + ", " + 
               getStock() + ", " + 
               getPrice() + ", " + 
               getNumberOfPages() + ", " + 
               getCondition();
    }
    @Override
    public String toFileString() {
        return getBarcode() + "," + 
                getBookType() + "," + 
                getTitle() + "," + 
                getLanguage() + "," + 
                getGenre() + "," + 
                getReleaseDate() + "," + 
                getStock() + "," + 
                getPrice() + "," + 
                getNumberOfPages() + "," + 
                getCondition();
    }

   
}
public class Ebook extends Books {
    private int numberOfPages;
    private String format;

    public Ebook(long barcode, String title, String language, String genre,
                 String releaseDate, int stock, double price, int numberOfPages, String format) {
        super(barcode, "ebook", title, language, genre, releaseDate, stock, price);
        this.numberOfPages = numberOfPages;
        this.format = format;
    }
    public int getNumberOfPages() {
    	return numberOfPages;
    }
    public String getFormat(){
    	return format;
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
               getFormat(); 
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
                getFormat();
    }

 
}
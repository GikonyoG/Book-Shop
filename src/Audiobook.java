public class Audiobook extends Books{
    private double listeningLength;
    private String format;

    public Audiobook(long barcode, String title, String language, String genre,
                     String releaseDate, int stock, double price, double listeningLength, String format) {
        super(barcode, "audiobook", title, language, genre, releaseDate, stock, price);
        this.listeningLength = listeningLength;
        this.format = format;
    }
    public double getListeningLength() {
        return listeningLength;
    }
    public String getFormat() {
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
               getListeningLength() + ", " +  
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
                getListeningLength() + ", " +  
                getFormat(); 
    }


   
}
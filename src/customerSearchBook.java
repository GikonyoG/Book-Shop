import java.util.List;
import java.util.stream.Collectors;

public class customerSearchBook {
    private List<Books> books;

    public customerSearchBook(List<Books> books) {
        this.books = books;
    }

    public List<Books> filterBooks(String searchText) {
        return books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains(searchText.toLowerCase())
                    || String.valueOf(book.getBarcode()).contains(searchText)
                    || book.getGenre().toLowerCase().contains(searchText.toLowerCase())
                    || book.getBookType().toLowerCase().contains(searchText.toLowerCase()))
            .collect(Collectors.toList());
    }

    public List<Books> filterAudioBooks(int listeningHours) {
        return books.stream()
            .filter(book -> book instanceof Audiobook && ((Audiobook) book).getListeningLength() > listeningHours)
            .collect(Collectors.toList());
    }
}

import java.util.List;

public class customerTotalPrice {
    private List<Books> cart;

    public customerTotalPrice(List<Books> cart) {
        this.cart = cart;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Books book : cart) {
            totalPrice += book.getPrice()*book.getStock();
        }

        return totalPrice;
    }
    
    
}

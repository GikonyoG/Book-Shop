 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class customerButtonHandler implements ActionListener {
    private test2 gui;
    private customerSearchBook searchService;
    private JLabel totalPriceLabel;
    private List<Books> cart;
    
    
  

    public customerButtonHandler(test2 gui) {
        this.gui = gui;
        this.totalPriceLabel = totalPriceLabel; 
        gui.getRefreshButton().addActionListener(this);
        gui.getSearchButton().addActionListener(this);
        gui.getClearCartButton().addActionListener(this);
        
        
        
        List<Books> books = customerFileHandler.readBooksFromFile("stock.txt");
        this.searchService = new customerSearchBook(books);
       
        
        
       
    }
    public void setTotalPriceLabel(JLabel totalPriceLabel) {
        this.totalPriceLabel = totalPriceLabel;
    }

    public void updateCartTable(List<Books> cart) {
        String[] columnNames = {"Type", "Title", "Language", "Genre", "Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        double totalPrice = 0.0;

        for (Books book : cart) {
            Object[] rowData = new Object[]{
                book.getBookType(),
                book.getTitle(),
                book.getLanguage(),
                book.getGenre(),
                book.getPrice()
            };
            model.addRow(rowData);

            totalPrice += book.getPrice();
        }

        gui.shoppingCartTable.setModel(model);
        gui.shoppingCartTable.repaint();

        totalPriceLabel.setText("Total: £" + String.format("%.2f", totalPrice));
        System.out.println("Total Price: " + totalPrice);
    }

    public void printTotalPrice() {
        double totalPrice = 0.0;
        List<Books> cart = gui.cartService.getCart();

        for (Books book : cart) {
            totalPrice += book.getPrice();
        }

        System.out.println("Total Price: " + totalPrice);
        totalPriceLabel.setText("Total Price: £" + String.format("%.2f", totalPrice));
    }
  








    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.getAddToCartButton()) {
            Books selectedBook = gui.getSelectedBook();
            if (selectedBook != null) {
                gui.cartService.addToCart(selectedBook);
                gui.cartService.updateCartTable(); 
                updateCartTable(gui.cartService.getCart());
                
                
            }
            // ...
        } else if (e.getSource() == gui.getRefreshButton()) {
	       	 List<Books> books = customerFileHandler.readBooksFromFile("stock.txt");
	         this.searchService = new customerSearchBook(books);
	
	        
	        String[] columnNames = {"Barcode", "Book Type", "Title", "Language", "Genre", "Release Date", "Stock", "Price", "No.Of Pages/Length", "Condition/Format"};
	
	        
	        Object[][] data = new Object[books.size()][columnNames.length];
	
	        
	        for (int i = 0; i < books.size(); i++) {
	            Books book = books.get(i);
	            data[i][0] = book.getBarcode();
	            data[i][1] = book.getBookType();
	            data[i][2] = book.getTitle();
	            data[i][3] = book.getLanguage();
	            data[i][4] = book.getGenre();
	            data[i][5] = book.getReleaseDate();
	            data[i][6] = book.getStock();
	            data[i][7] = book.getPrice();
	            
	            if (book instanceof Paperback) {
	                data[i][8] = ((Paperback) book).getNumberOfPages();
	                data[i][9] = ((Paperback) book).getCondition();
	            } else if (book instanceof Audiobook) {
	                data[i][8] = ((Audiobook) book).getListeningLength();
	                data[i][9] = ((Audiobook) book).getFormat();
	            } else if (book instanceof Ebook) {
	                data[i][8] = ((Ebook) book).getNumberOfPages();
	                data[i][9] = ((Ebook) book).getFormat();
	            }
	        }
	
	
	        
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	
	        
	        gui.getViewBooksTable().setModel(model);
            // ...
        } else if (e.getSource() == gui.getSearchButton()) {
            String searchText = gui.getSearchField().getText();
            String selectedCategory = gui.getComboBox().getSelectedItem().toString();
            List<Books> filteredBooks;

            if (selectedCategory.equals("Barcode/Others")) {
                filteredBooks = searchService.filterBooks(searchText);
            } else { // "Listening Hours"
                filteredBooks = searchService.filterAudioBooks(Integer.parseInt(searchText));
            }

            DefaultTableModel tableModel = createBookTableModel(filteredBooks);
            gui.getViewBooksTable().setModel(tableModel);
            // ...
        } else if (e.getSource() == gui.getClearCartButton()) {
            
            updateCartTable(gui.cartService.getCart());
            gui.cartService.updateCartTable(); 
            gui.cartService.clearCart();
            
        }else if (e.getSource() == gui.getcheckoutButton()) {
            List<Books> cartBooks = gui.cartService.getCart();
            List<Books> allBooks = Books.loadBooksFromFile("Stock.txt"); 

            for (Books cartBook : cartBooks) {
                for (Books book : allBooks) {
                    if (book.getBarcode() == cartBook.getBarcode()) { 
                        book.setStock(book.getStock() - 1); 
                        String receipt = "Thank you for the purchase!";
                        JOptionPane.showMessageDialog(gui, receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);
//                        

                        
                       
                        
                        
                        break;
                    }
                }
            }

            Books.writeBooksToFile(allBooks, "stock.txt"); 
            String receipt = "Thank you for the purchase!";
          
        }

    }


    private DefaultTableModel createBookTableModel(List<Books> books) {
        
        String[] columnNames = {"Barcode", "Book Type", "Title", "Language", "Genre", "Release Date", "Stock", "Price", "No.Of Pages/Length", "Condition/Format"};
        Object[][] data = new Object[books.size()][columnNames.length];
        
        for (int i = 0; i < books.size(); i++) {
            Books book = books.get(i);
            data[i][0] = book.getBarcode();
            data[i][1] = book.getBookType();
            data[i][2] = book.getTitle();
            data[i][3] = book.getLanguage();
            data[i][4] = book.getGenre();
            data[i][5] = book.getReleaseDate();
            data[i][6] = book.getStock();
            data[i][7] = book.getPrice();
            
            if (book instanceof Paperback) {
                data[i][8] = ((Paperback) book).getNumberOfPages();
                data[i][9] = ((Paperback) book).getCondition();
            } else if (book instanceof Audiobook) {
                data[i][8] = ((Audiobook) book).getListeningLength();
                data[i][9] = ((Audiobook) book).getFormat();
            } else if (book instanceof Ebook) {
                data[i][8] = ((Ebook) book).getNumberOfPages();
                data[i][9] = ((Ebook) book).getFormat();
            }
        }
        return new DefaultTableModel(data, columnNames);
    }
    public void addToCart(Books selectedBook) {
        cart.add(selectedBook);
        updateCartTable(cart); 
    }
    public void clearCart() {
        cart.clear();
    }

}


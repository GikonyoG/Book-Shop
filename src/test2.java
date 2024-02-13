import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.Vector;

public class test2 extends JFrame {

	private JPanel contentPane;
    private JTable viewBooksTable;
    private JTextField searchField;
    private JButton searchButton;
    JTable shoppingCartTable;
    private JButton refreshButton;
    private JButton addToCartButton;
    private JLabel shoppingCartLabel;
    private JLabel customerInfoLabel;
    JButton clearCartButton;
    private JButton checkoutButton;
    private DefaultTableModel shoppingcartModel;
    private JComboBox comboBox;
    private JButton loadTableButton;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;
    private List<Books> books;
    public UserAccount currentUser;
	


        public JButton getSearchButton() {
        return searchButton;
    }

    
    public JTextField getSearchField() {
        return searchField;
    }
	  
    public JTable getViewBooksTable() {
        return viewBooksTable;
    }

   
    public JButton getRefreshButton() {
        return refreshButton;
    }
    public JComboBox getComboBox() {
        return comboBox;
    }
    public JButton getAddToCartButton() {
        return addToCartButton;
    }
    public JButton getClearCartButton() {
    	return clearCartButton;
    }
    public JButton getcheckoutButton() {
    	return checkoutButton;
    	
    }
    public Books getSelectedBook() {
        int selectedRow = viewBooksTable.getSelectedRow();
        if (selectedRow < 0 || selectedRow >= books.size()) {
            return null;
        }
        return books.get(selectedRow);
    }
    public class CartService {
    	 

    	public void clearCart() {
    	    cart.clear();
    	}
    	
        private List<Books> cart = new ArrayList<>();
        
        
        public double calculateTotalCost() {
            double totalCost = 0.0;
            for (Books book : cart) {
                totalCost += book.getPrice();  
            }
            return totalCost;
        }
        public double getTotalPrice() {
            double total = 0.0;
            for (Books book : cart) {
                total += book.getPrice();
            }
            return total;
        }


        public void addToCart(Books book) {
        	
            cart.add(book);
        }
        public void updateCartTable() {
        	shoppingcartModel.setRowCount(0);
        	for(Books book : cart) {
        		shoppingcartModel.addRow(new Object[] {book.barcode,book.title,book.language,book.genre,book.releaseDate,book.stock,book.price});
        	}
        	System.out.println(cart);
        	
        }
        public List<Books> getCart() {
            return this.cart;
        }

            }
    CartService cartService = new CartService();
    private JLabel totalPriceLabel;
    private JButton logOutButton;
    public JLabel getTotalPriceLabel() {
        return totalPriceLabel;
    }
    
    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public JLabel getCustomerInfoLabel() {
        return customerInfoLabel;
    }

   






	
    public test2(UserAccount currentUser) {
		this.books = customerFileHandler.readBooksFromFile("stock.txt");
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 107, 937, 311);
		contentPane.add(scrollPane);
		
		viewBooksTable = new JTable();
		scrollPane.setViewportView(viewBooksTable);
		
		searchField = new JTextField();
		searchField.setBounds(341, 45, 130, 26);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(518, 45, 117, 29);
		contentPane.add(searchButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 468, 686, 202);
		contentPane.add(scrollPane_1);
		
		shoppingCartTable = new JTable();
		scrollPane_1.setViewportView(shoppingCartTable);
		
		String[] columns = {"Barcode","Title","Language","Genre","Release Date","Quantity","Retail Price"};
		shoppingcartModel = new DefaultTableModel(columns, 0);
		shoppingCartTable.setModel((TableModel) shoppingcartModel);
		
		refreshButton = new JButton("Refresh Table");
		refreshButton.setBounds(940, 178, 117, 29);
		contentPane.add(refreshButton);
		
		
		
	    
		
	    addToCartButton = new JButton("Add To Cart");
	    addToCartButton.setBounds(940, 260, 117, 29);
	    contentPane.add(addToCartButton);
	    
	    clearCartButton = new JButton("Clear Cart");
		clearCartButton.setBounds(826, 483, 117, 29);
		contentPane.add(clearCartButton);
		
		checkoutButton = new JButton("Checkout");
		checkoutButton.setBounds(826, 553, 117, 29);
		contentPane.add(checkoutButton);
		
		JLabel totalPriceLabel = new JLabel("");
        totalPriceLabel.setBounds(720, 540, 107, 16);
        contentPane.add(totalPriceLabel);
        
        customerButtonHandler buttonHandler = new customerButtonHandler(this);
        buttonHandler.setTotalPriceLabel(totalPriceLabel);

		
		searchButton.addActionListener(buttonHandler);
		refreshButton.addActionListener(buttonHandler);
		addToCartButton.addActionListener(buttonHandler);  
		clearCartButton.addActionListener(buttonHandler);
		checkoutButton.addActionListener(buttonHandler);  


	    
		
		shoppingCartLabel = new JLabel("Shopping Cart");
		shoppingCartLabel.setBounds(208, 440, 117, 16);
		contentPane.add(shoppingCartLabel);
		
		customerInfoLabel = new JLabel();
        customerInfoLabel.setText("Hello. "+currentUser.getUsername() + " , Credit Balance is: " + currentUser.getBalance()); 
        customerInfoLabel.setBounds(33, 6, 310, 16); 
        contentPane.add(customerInfoLabel);

		
		
		
		
		String[] categories = {"Barcode/Others","Listening Hours"};
		comboBox = new JComboBox(categories);
		comboBox.setBounds(169, 46, 160, 26);
		contentPane.add(comboBox);
		
		logOutButton = new JButton("Log Out");
		logOutButton.setBounds(905, 6, 117, 29);
		contentPane.add(logOutButton);
		
		


	}
	
}



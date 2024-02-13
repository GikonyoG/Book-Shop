import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class test extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField barcodeTextField;
	private JTextField titleTextField;
	private JTextField languageTextField;
	private JTextField GenreTextField;
	private JTextField releaseDateTextField;
	private JTextField StockTextField;
	private JTextField priceTextField;
	private JTextField additional1TextField;
	private JTextField additional2TextField;
	private JButton loadTableButton;
	private JComboBox typeOfBookcomboBox;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane viewBooksTable = new JScrollPane();
		viewBooksTable.setBounds(20, 343, 993, 316);
		contentPane.add(viewBooksTable);
		
		table = new JTable();
		viewBooksTable.setViewportView(table);
		
		barcodeTextField = new JTextField();
		barcodeTextField.setBounds(66, 73, 130, 26);
		contentPane.add(barcodeTextField);
		barcodeTextField.setColumns(10);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(444, 73, 130, 26);
		contentPane.add(titleTextField);
		titleTextField.setColumns(10);
		
		languageTextField = new JTextField();
		languageTextField.setBounds(804, 73, 130, 26);
		contentPane.add(languageTextField);
		languageTextField.setColumns(10);
		
		GenreTextField = new JTextField();
		GenreTextField.setBounds(66, 162, 130, 26);
		contentPane.add(GenreTextField);
		GenreTextField.setColumns(10);
		
		releaseDateTextField = new JTextField();
		releaseDateTextField.setBounds(444, 149, 130, 26);
		contentPane.add(releaseDateTextField);
		releaseDateTextField.setColumns(10);
		
		StockTextField = new JTextField();
		StockTextField.setBounds(804, 149, 130, 26);
		contentPane.add(StockTextField);
		StockTextField.setColumns(10);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(66, 235, 130, 26);
		contentPane.add(priceTextField);
		priceTextField.setColumns(10);
		
		additional1TextField = new JTextField();
		additional1TextField.setBounds(444, 235, 130, 26);
		contentPane.add(additional1TextField);
		additional1TextField.setColumns(10);
		
		additional2TextField = new JTextField();
		additional2TextField.setBounds(804, 235, 130, 26);
		contentPane.add(additional2TextField);
		additional2TextField.setColumns(10);
		
		JButton addBookButton = new JButton("Add Book");
		addBookButton.setBounds(267, 288, 117, 29);
		contentPane.add(addBookButton);
		
		loadTableButton = new JButton("Refresh Table");
		loadTableButton.setBounds(656, 288, 117, 29);
		contentPane.add(loadTableButton);
		
		adminFileHandler fileHandler = new adminFileHandler();
		adminButtonController controller = new adminButtonController(this, fileHandler,addBookButton);
		loadTableButton.addActionListener(controller);

		loadTableButton.addActionListener(controller);
		addBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addBookButtonActionPerformed(e);
			}
		});

	
	    

	    String[] categories = {"paperback","ebook","audiobook"};
		typeOfBookcomboBox = new JComboBox(categories);
		typeOfBookcomboBox.setBounds(430, 18, 144, 26);
		contentPane.add(typeOfBookcomboBox);
		
		JLabel barcodeLabel = new JLabel("Barcode");
		barcodeLabel.setBounds(66, 56, 61, 16);
		contentPane.add(barcodeLabel);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(444, 56, 61, 16);
		contentPane.add(titleLabel);
		
		JLabel languageLabel = new JLabel("Language");
		languageLabel.setBounds(804, 56, 61, 16);
		contentPane.add(languageLabel);
		
		JLabel genreLabel = new JLabel("Genre");
		genreLabel.setBounds(66, 149, 61, 16);
		contentPane.add(genreLabel);
		
		JLabel releaseDateLabel = new JLabel("Release Date");
		releaseDateLabel.setBounds(444, 134, 108, 16);
		contentPane.add(releaseDateLabel);
		
		JLabel quantityLabel = new JLabel("Quantity In Stock");
		quantityLabel.setBounds(814, 134, 120, 16);
		contentPane.add(quantityLabel);
		
		JLabel priceLabel = new JLabel("Retail Price");
		priceLabel.setBounds(66, 219, 106, 16);
		contentPane.add(priceLabel);
		
		JLabel additional1Label = new JLabel("Number Of Pages");
		additional1Label.setBounds(444, 219, 130, 16);
		contentPane.add(additional1Label);
		
		JLabel additional2Label = new JLabel("Condition");
		additional2Label.setBounds(804, 219, 88, 16);
		contentPane.add(additional2Label);
		
		JLabel typeOfBookLabel = new JLabel("Type Of Book:");
		typeOfBookLabel.setBounds(323, 22, 95, 16);
		contentPane.add(typeOfBookLabel);
		
	

	}
	public JButton getLoadTableButton() {
	    return loadTableButton;
	}

	public JTable getTable() {
	    return table;
	}
	public JTextField getBarcodeTextField() {
	    return barcodeTextField;
	}

	public JTextField getTitleTextField() {
	    return titleTextField;
	}

	public JTextField getLanguageTextField() {
	    return languageTextField;
	}

	public JTextField getGenreTextField() {
	    return GenreTextField;
	}

	public JTextField getReleaseDateTextField() {
	    return releaseDateTextField;
	}

	public JTextField getStockTextField() {
	    return StockTextField;
	}

	public JTextField getPriceTextField() {
	    return priceTextField;
	}

	public JTextField getAdditional1TextField() {
	    return additional1TextField;
	}

	public JTextField getAdditional2TextField() {
	    return additional2TextField;
	}

	public JComboBox getTypeOfBookComboBox() {
	    return typeOfBookcomboBox;
	}
	
	


	
}

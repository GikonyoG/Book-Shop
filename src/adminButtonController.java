import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class adminButtonController implements ActionListener {
    private test gui;
    private adminFileHandler fileHandler;
    private test frame;
    private JButton addBookButton;
    
    public adminButtonController(test frame, adminFileHandler fileHandler, JButton addBookButton) {
        this.frame = frame;
        this.fileHandler = fileHandler;
        this.gui = frame;
        this.addBookButton = addBookButton;
        
    }

    public adminButtonController(test gui, adminFileHandler fileHandler) {
    	 this.gui = gui;
         this.fileHandler = fileHandler;
         this.addBookButton = addBookButton;
         gui.getLoadTableButton().addActionListener(this);
         addBookButton.addActionListener(this);
        
       
    }
 
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.getLoadTableButton()) {
            

            List<Books> books = fileHandler.readBooksFromFile("Stock.txt");
            

            
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

            
            gui.getTable().setModel(model);
        }else if (e.getSource() == addBookButton) {
            addBookButtonActionPerformed(e);
        }
    }
    public void addBookButtonActionPerformed(ActionEvent e) {
       
        long barcode = Long.parseLong(frame.getBarcodeTextField().getText());
        String bookType = (String)frame.getTypeOfBookComboBox().getSelectedItem();
        String title = frame.getTitleTextField().getText();
        String language = frame.getLanguageTextField().getText();
        String genre = frame.getGenreTextField().getText();
        String releaseDate = frame.getReleaseDateTextField().getText();
        int stock = Integer.parseInt(frame.getStockTextField().getText());
        double price = Double.parseDouble(frame.getPriceTextField().getText());
        
        
        Books newBook = null;

       
        switch (bookType.toLowerCase()) {
            case "paperback":
                int numberOfPages = Integer.parseInt(frame.getAdditional1TextField().getText());
                String condition = frame.getAdditional2TextField().getText();
                newBook = new Paperback(barcode, title, language, genre, releaseDate, stock, price, numberOfPages, condition);
                break;
            case "audiobook":
                double listeningLength = Double.parseDouble(frame.getAdditional1TextField().getText());
                String format = frame.getAdditional2TextField().getText();
                newBook = new Audiobook(barcode, title, language, genre, releaseDate, stock, price, listeningLength, format);
                break;
            case "ebook":
                numberOfPages = Integer.parseInt(frame.getAdditional1TextField().getText());
                format = frame.getAdditional2TextField().getText();
                newBook = new Ebook(barcode, title, language, genre, releaseDate, stock, price, numberOfPages, format);
                break;
        }
        
        
        if (newBook != null) {
            
            fileHandler.writeBook(newBook);
            
            frame.getBarcodeTextField().setText("");
            frame.getTitleTextField().setText("");
            frame.getLanguageTextField().setText("");
            frame.getGenreTextField().setText("");
            frame.getReleaseDateTextField().setText("");
            frame.getStockTextField().setText("");
            frame.getPriceTextField().setText("");
            frame.getAdditional1TextField().setText("");
            frame.getAdditional2TextField().setText("");
            frame.getTypeOfBookComboBox().setSelectedIndex(0);
        } else {
           
            System.out.println("Invalid book type");
        }
    }
}




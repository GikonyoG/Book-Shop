import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class loginFrame extends JFrame {

    private JPanel contentPane;
    private List<UserAccount> users;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginFrame frame = new loginFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        users = Login.readUserAccountsFromFile("UserAccounts.txt");
        
       
        String[] usernames = users.stream().map(UserAccount::getUsername).toArray(String[]::new);
        JComboBox comboBox = new JComboBox(usernames);
        comboBox.setBounds(132, 87, 158, 27);
        contentPane.add(comboBox);
        
       
        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(156, 136, 117, 29);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserAccount selectedUser = users.get(comboBox.getSelectedIndex());
                if (selectedUser.getRole().equals("admin")) {
                    
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
                } else {
                    
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                test2 frame = new test2(selectedUser);
                                frame.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                
                loginFrame.this.setVisible(false);
            }
        });
        contentPane.add(loginButton);
    }
}

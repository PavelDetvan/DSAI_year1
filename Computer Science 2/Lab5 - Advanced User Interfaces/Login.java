//package EX2;

import javax.swing.*;

import java.awt.LayoutManager;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;



public class Login extends LoginManager implements ActionListener{
    JTextField usernameField = new JTextField(20);
    JPasswordField passworField = new JPasswordField(20);
    JLabel attemptsLabel = new JLabel();
    JFrame frame = new JFrame();
    JButton logInButton = new JButton("Log In");
    //private int attemptsLeft = 3;
    private String username;
    private String password;

    public Login(){
        
        logInButton.addActionListener(this);

        JLabel usernameLabel = new JLabel("Username: ");

        JLabel passwordLabel = new JLabel("Password: ");

        JPanel panel = new JPanel();
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passworField);
        panel.add(logInButton);
        panel.add(attemptsLabel);
        
        
        
        frame.setSize(300, 300);
        frame.setTitle("LogIn Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        username = usernameField.getText().toLowerCase();
        password = passworField.getText();
        
        if(e.getSource()==logInButton){
            if(login(username,password)){
                System.out.println(username + password);

                frame.dispose();

                JLabel label = new JLabel("HELLO");
                label.setFont(new Font("MV Boli", Font.PLAIN, 20));
                
                JFrame welcomeFrame = new JFrame();
                welcomeFrame.setSize(200, 200);
                welcomeFrame.setTitle("Welcome");
                welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                welcomeFrame.setResizable(false);
                welcomeFrame.setVisible(true);
                welcomeFrame.add(label);

            }
            else{
                if(getAttempts()>=3){
                    frame.dispose();;
                    JOptionPane.showMessageDialog(null, "Not Authorized!","Message", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                else{
                    //attemptsLabel.setText("Attempts left " + Integer.toString(attemptsLeft));
                    //attemptsLeft--;
                    attemptsLabel.setText("You failed " + getAttempts() + " times");
                }
            }
        }
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        Login login = new Login();    
    }
    
}
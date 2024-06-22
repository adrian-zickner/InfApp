package infapp;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Color; // Add this import statement
import java.sql.*;

public class Login {

    private DBVerbindung verbindung;
    
    

    public void showStuff() {

        try {
            this.verbindung = new DBVerbindung("https://panel.zickner.com/", "zadmin_notizapp", "zadmin_sql", "pequmady3emy6e7u");
            this.verbindung.open();
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Verbindung fehlerhaft!");
            // TODO: handle exception
        }


        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);



        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);



        JTextField usernameTextfield = new JTextField("User eingeben");
        usernameTextfield.setBounds(250, 250, 100, 20);

        JTextField passwordTextField = new JTextField("Passw eingeben");
        passwordTextField.setBounds(250, 300, 100, 20);

        usernameTextfield.setBorder(blackline);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250,350,100,30);

        JButton registerUser = new JButton("Neu Registrieren");
        registerUser.setBounds(225,400,150,30);

        loginButton.addActionListener((ActionListener) new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        String UserValue = usernameTextfield.getText();
                    }  
                });  

        registerUser.addActionListener((ActionListener) new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        String UserValue = usernameTextfield.getText();
                        String PasswdValue = passwordTextField.getText();

                        registerUser(UserValue, PasswdValue);




                    }  
                });          

        frame.add(loginButton);
        frame.add(usernameTextfield);
        frame.add(passwordTextField);


        frame.add(registerUser);


        frame.setLayout(null);
        frame.setVisible(true);



    }
    public void registerUser(String username, String password) {
        String sql = "INSERT INTO users (Username, Password) VALUES (?, ?)";
        try {
            verbindung.prepareAndExecuteStatement(sql, username, password);
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while registering user.");
        } finally {
            try {
                verbindung.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}

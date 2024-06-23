package infapp;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Color; // Add this import statement
import java.sql.*;

public class Login {

    private DBVerbindung verbindung;
    GUI gui = new GUI();
    int userkey = 0;

    public void showStuff() {

        try {
            this.verbindung = new DBVerbindung("localhost", "projekt", "root", "");
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

        JPasswordField passwordTextField = new JPasswordField("Passw eingeben");
        passwordTextField.setBounds(250, 300, 100, 20);

        usernameTextfield.setBorder(blackline);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 350, 100, 30);

        JButton registerUser = new JButton("Neu Registrieren");
        registerUser.setBounds(225, 400, 150, 30);

        loginButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    verbindung.open();
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                String UserValue = usernameTextfield.getText();
                char[] password = passwordTextField.getPassword();

                String PasswValue = new String(password);

                if (verbindung.checkUser(UserValue, PasswValue)) {
                    frame.dispose();
                    gui.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(frame, "Password oder Username falsch!");
                }
            }
        });

        registerUser.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    verbindung.open();
                } catch (ClassNotFoundException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                String UserValue = usernameTextfield.getText();
                char[] password = passwordTextField.getPassword();

                String PasswValue = new String(password);
                userkey++;
                registerUser(UserValue, PasswValue);

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

        JFrame error = new JFrame(); // Declare the frame variable
        if (verbindung.checkUser(username, password)) {
            JOptionPane.showMessageDialog(error, "Username bereits registriert!");
            return;
        }

        String sql = "INSERT INTO user(username, password) VALUES (?, ?)";
        try {
            verbindung.prepareAndExecuteStatement(sql, username, password);
            JOptionPane.showMessageDialog(error, "User erfolgreich registriert!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler bei Registrierung!");
        } finally {
            try {
                verbindung.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}

package infapp;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Color; // Add this import statement


public class Login {


    public void showStuff() {
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);



        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);



        JTextField usernameTextfield = new JTextField("");
        usernameTextfield.setBounds(250, 250, 100, 20);

        usernameTextfield.setBorder(blackline);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250,300,100,30);

        loginButton.addActionListener((ActionListener) new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        usernameTextfield.setText("Welcome.");  
                    }  
                });  

        frame.add(loginButton);
        frame.add(usernameTextfield);


        frame.setLayout(null);
        frame.setVisible(true);



    }



}

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



        JTextField usernameTextfield = new JTextField("User eingeben");
        usernameTextfield.setBounds(250, 250, 100, 20);

        usernameTextfield.setBorder(blackline);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250,300,100,30);

        loginButton.addActionListener((ActionListener) new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        String UserValue = usernameTextfield.getText();
                        checkUsername(UserValue);
                    }  
                });  

        frame.add(loginButton);
        frame.add(usernameTextfield);


        frame.setLayout(null);
        frame.setVisible(true);



    }
    void checkUsername(String Username){
        if(Username == "Marci"){
            System.out.println("Login complete!");
        }else{
            System.err.println("No real Username");
        }

    }



}

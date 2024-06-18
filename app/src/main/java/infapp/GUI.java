package infapp;

import javax.swing.JFrame;

public class GUI {
    public GUI() {
        try {
            showStuff();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void showStuff() {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        initComponent();

    }

    public void clickNeueNotiz(){

    }
    public void clickNotizSpeichern(){

    }
    private void zeigeNotiz(){
        
    }

    private static void initComponent() {

        System.out.println("Hello");

    }

}

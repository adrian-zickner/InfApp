/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package infapp;

public class App {
    private String user;
    private String passwort;
    private int AnzahlNotizen;
    private int AnzahlKategorien;


    public String getGreeting() {
        return "Hello World!";
    }

    public void ueberpruefeUser(){

    }
    public void erstelleUser(){

    }
    public void loescheUser(){

    }
    public int holeAnzahlNotizen(){
        int anzahl = 0;
        return anzahl;
    }

    public int holeAnzahlKategorien(){
        int anzahl = 0;
        return anzahl; 
    }







    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        GUI fifi = new GUI();
        fifi.showStuff();
        ;
    }
}
package infapp;

import java.sql.SQLException;

public class Notiz {

    DBVerbindung verbundung;

    private int N_ID;
    private String Inhalt;
    private String Kategorie;
    private int U_ID;

    public void holeNotiz(int NotizID) {
        String sql = "INSERT INTO notiz(Titel, Inhalt, Kategorie) VALUES (?, ?, ?)";
        try {
            verbindung.prepareAndExecuteStatement(sql, titel, "null", "null");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler bei Ezeugung!");
        } finally {
            try {
                verbindung.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void löscheNotiz(int NotizID) {
        // Löschen aus DB

    }

    public void bearbeiteNotiz() {
        /*
         * TODO: Anhand von holeNotiz diese dann bearbeiten
         * -- Marcello Pirillo --
         */
    }

}

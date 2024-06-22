package infapp;

import java.sql.*;

public class DBVerbindung {

    private Connection verbindung;

    private String server;
    private String datenbank;
    private String user;
    private String passwort;

    public DBVerbindung(String server, String datenbank, String user, String passwort) {
        this.server = server;
        this.datenbank = datenbank;
        this.user = user;
        this.passwort = passwort;
    }

    public void open() throws ClassNotFoundException, SQLException {

        // Class.forName("com.mysql.jdbc.Driver");
        verbindung = DriverManager.getConnection("jdbc:mysql://" + this.server + ":3306/" + this.datenbank + "",
                "" + this.user + "", "" + this.passwort + "");
    }

    public void close() throws SQLException {

        verbindung.close();
    }

    public ResultSet fuehreAbfrageAus(String sqlBefehl) throws SQLException {

        Statement sqlStatement = verbindung.createStatement();
        ResultSet rs = sqlStatement.executeQuery(sqlBefehl);

        return rs;
    }

    /*public PreparedStatement prepareStatement(String abfrage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }*/

    
    public void prepareAndExecuteStatement(String sql, Object... parameters) throws SQLException {
        try (PreparedStatement pstmt = verbindung.prepareStatement(sql)) {
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
            pstmt.executeUpdate();
        }
    }

}
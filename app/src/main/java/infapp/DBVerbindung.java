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

    public ResultSet fuehreAbfrageAus(String sql, String... params) {
        try (PreparedStatement pstmt = verbindung.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setString(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*public PreparedStatement prepareStatement(String abfrage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }*/

    public boolean checkUser(String username, String password) {
        String query = "SELECT COUNT(*) FROM user WHERE username = ? AND passw = ?";
        try (PreparedStatement pstmt = verbindung.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, String.valueOf(password));
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public void prepareAndExecuteStatement(String sql, Object... parameters) throws SQLException {
        try (PreparedStatement pstmt = verbindung.prepareStatement(sql)) {
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
            pstmt.executeUpdate();
        }
    }



}
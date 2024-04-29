package org.example;


import java.sql.*;

public class Database {
    private static final String URL =
            "jdbc:mariadb://localhost/books";
    private static final String USER = "root";
    private static final String PASSWORD = null;
    public static Connection connection = null;

    public Database() {
    }

    public static Connection getConnection() {
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
            }
        }catch (SQLException e){
            System.out.println("Eroare la obtinerea conexiunii" + e.getMessage());
        }
        return connection;
    }

    public void createConnection() {
        try (Connection conn = DriverManager.getConnection  (URL, USER, PASSWORD)) {
            if (conn != null) {
                connection = conn;
                System.out.println("Conexiunea la baza de date a fost realizată cu succes!");

                try (Statement stmt = conn.createStatement()) {
                    try (ResultSet rs = stmt.executeQuery("SELECT autor, titlu FROM collection")) {
                        while (rs.next()) {
                            String username = rs.getString("autor");
                            String password = rs.getString("titlu");
                            System.out.println("Autor: " + username + ", Titlu: " + password);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare de conectare la baza de date: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (connection == null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexiunea la baza de date a fost închisă cu succes!");
            }
        }
        catch (SQLException e){
            System.out.println("Eroare la închiderea conexiunii la baza de date: " + e.getMessage());

        }

    }
}

package org.example;

import java.sql.*;

public class BookDAO {
    public void create(int year, String title, String author, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO collection (An, Titlu, Autor, Categorie) VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
            System.out.println("Cartea a fost adăugată cu succes în baza de date.");
        }
    }

    public Carte findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM collection WHERE Titlu = ?");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Carte carte = new Carte(rs.getInt("Id"),
                    rs.getString("Autor"),
                    rs.getString("Titlu"),
                    rs.getDouble("average_rating"),
                    rs.getInt("An"),
                    rs.getString("Categorie"));
            return carte;
        } else {
            return null;
        }
    }

    public static void closeConnection() {
        Connection con = Database.getConnection();
        try {
            if (con == null && !con.isClosed()) {
                con.close();
                System.out.println("Conexiunea la baza de date a fost închisă cu succes!");
            }
        }
        catch (SQLException e){
            System.out.println("Eroare la închiderea conexiunii la baza de date: " + e.getMessage());

        }
    }

}

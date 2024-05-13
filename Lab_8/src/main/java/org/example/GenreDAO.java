package org.example;

import java.sql.*;

public class GenreDAO {
    public void create(String category) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO collection (Categorie) VALUES (?)")) {
            pstmt.setString(1, category);
            pstmt.executeUpdate();
            System.out.println("Categoria a fost adăugată cu succes în baza de date.");
        }
    }

    public Carte findByCategory(String category) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM collection WHERE Categorie = ?");
        pstmt.setString(1, category);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Carte carte = new Carte(rs.getInt("Id"),
                    rs.getString("autor"),
                    rs.getString("titlu"),
                    rs.getDouble("average_rating"),
                    rs.getInt("An"),
                    rs.getString("Categorie"));
            return carte;
        } else {
            return null;
        }
    }

    public Carte findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM collection WHERE Id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Construim obiectul Carte folosind valorile din ResultSet
            Carte carte = new Carte(rs.getInt("Id"),
                    rs.getString("autor"),
                    rs.getString("titlu"),
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

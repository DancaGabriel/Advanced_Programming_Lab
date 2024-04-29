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

    public ResultSet findByCategory(String category) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM collection WHERE Categorie = ?");
        pstmt.setString(1, category);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("Id");
            String categoryName = rs.getString("Categorie");
            System.out.println("Id: " + id + ", Categorie: " + categoryName);
        }
        return rs;
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT Categorie FROM collection WHERE Id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("Categorie");
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

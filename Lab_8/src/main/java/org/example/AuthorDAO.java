package org.example;

import java.sql.*;

public class AuthorDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO collection (autor) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Autorul a fost adăugat cu succes în baza de date.");
        }
    }

    public Carte findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM collection WHERE autor = ?");
        pstmt.setString(1, name);
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

}

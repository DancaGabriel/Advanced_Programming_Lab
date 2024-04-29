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

    public ResultSet findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT autor, titlu FROM collection WHERE autor = ?");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String autor = rs.getString("autor");
            String titlu = rs.getString("titlu");
            System.out.println("Autor: " + autor + ", Titlu: " + titlu);
        }
        return rs;
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
                "SELECT titlu FROM collection WHERE id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("titlu");
        } else {
            return null;
        }
    }

}

package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreDAO {

    public void create(String genreName) throws SQLException {
        Connection con = Database.getConnection();
        String insertSQL = "INSERT INTO genres (genre_name) VALUES (?)";
        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
            stmt.setString(1, genreName);

            stmt.executeUpdate();
        }
    }
}


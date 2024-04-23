package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {

    public void create(String title, String authorName, String type) throws SQLException {
        Connection con = Database.getConnection();

        AuthorDAO authorDAO = new AuthorDAO();

        String insertSQL = "INSERT INTO books (title, author_id, type) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
            Integer authorId = authorDAO.findByName(authorName);

            if (authorId == null) {
                throw new SQLException("Author does not exist.");
            }

            stmt.setString(1, title);
            stmt.setInt(2, authorId);
            stmt.setString(3, type);

            stmt.executeUpdate();
        }
    }
}

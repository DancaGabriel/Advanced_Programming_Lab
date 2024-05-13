package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database db = new Database();
            db.createConnection();
            System.out.println("Incercam autorul");
            AuthorDAO authors = new AuthorDAO();
            authors.findByName("Victor Hugo");
            authors.create("Mihail Sebastian");
            var genres = new GenreDAO();
            genres.create("Tragedy");
            genres.findByCategory("Tragedy");
            var books = new BookDAO();
            books.create(1597, "Romeo and Juliet", "William Shakespeare", "Tragedy");
            books.create(1979, "The Hitchhiker's Guide to the Galaxy",
                    "Douglas Adams", "Science fiction, Comedy, Adventure");
            books.findByName("Mizerabilii");
            DataImporter dataImport = new DataImporter();
//            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}
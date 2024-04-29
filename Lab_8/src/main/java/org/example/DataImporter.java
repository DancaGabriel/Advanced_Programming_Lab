package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataImporter {
    DataImporter() {
        String csvFilePath = "D:\\Java_College\\books.csv";

        String url = "jdbc:mariadb://localhost/books";
        String user = "root";
        String password = null;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String sql = "INSERT INTO collection (Id, titlu, autor) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, Integer.parseInt(data[0].trim()));
                    pstmt.setString(2, data[1].trim());
                    pstmt.setString(3, data[2].trim());
                  //  pstmt.setFloat(4, Float.parseFloat(data[3].trim()));

                    pstmt.executeUpdate();
                }
            }

            System.out.println("Datele au fost importate cu succes!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.sql.*;

public class Carte {
    private int Id;
    private String autor;
    private String titlu;
    private double average_rating;
    private int An;
    private String Categorie;

    // Constructor
    public Carte(int Id, String autor, String titlu, double average_rating, int An, String Categorie) {
        this.Id = Id;
        this.autor = autor;
        this.titlu = titlu;
        this.average_rating = average_rating;
        this.An = An;
        this.Categorie = Categorie;
    }

    // Getters
    public int getId() {
        return Id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitlu() {
        return titlu;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public int getAn() {
        return An;
    }

    public String getCategorie() {
        return Categorie;
    }
}

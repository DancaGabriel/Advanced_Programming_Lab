package org.example;

public class Alien {
    private String autor;
    private int id;

    private String titlu;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "autor='" + autor + '\'' +
                ", id=" + id +
                ", titlu='" + titlu + '\'' +
                '}';
    }
}

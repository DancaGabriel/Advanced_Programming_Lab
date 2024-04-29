package org.example;


import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity
@NamedQuery(
        name = "authors.findByName",
        query = "SELECT a FROM authors a WHERE a.name LIKE :namePattern"
)
public class authors {
   @Id
    private String name;
   private int id;

    public String getNume() {
        return name;
    }

    public void setNume(String nume) {
        this.name = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "authors{" +
                "nume='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}


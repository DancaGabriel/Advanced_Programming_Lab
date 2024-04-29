package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        collection c = new collection();

        c.setId(6);
        c.setAutor("Maria");
        c.setTitlu("Mare");

        authors a1 = new authors();
        a1.setNume("Alexandru Dumas");
        a1.setId(4);
        TestJPA start = new TestJPA();
        start.persisAuthor(a1);
        start.persisCollection(c);
        start.commitToDatabase();

        System.out.println(c);
        System.out.println(a1);
    }
}

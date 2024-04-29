package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TestJPA {

    public EntityManager em;
    public EntityManagerFactory emf;

    TestJPA(){

         emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();

        em.getTransaction().begin();
    }

    private EntityManager entityManager;

    public void AuthorsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public authors findById(int id) {
        return entityManager.find(authors.class, id);
    }

    public List<authors> findByName(String namePattern) {
        TypedQuery<authors> query = entityManager.createNamedQuery("authors.findByName", authors.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }

    public void persisAuthor(authors a){
        em.persist(a);
    }

    public void persisCollection(collection a){
        em.persist(a);
    }

    public void commitToDatabase(){

        em.getTransaction().commit();

    }


}

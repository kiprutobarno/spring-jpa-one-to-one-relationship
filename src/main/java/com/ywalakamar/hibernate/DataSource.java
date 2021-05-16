package com.ywalakamar.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataSource {

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = this.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ProductsDb");
    }
}

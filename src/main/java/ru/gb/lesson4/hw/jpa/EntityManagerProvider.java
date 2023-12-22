package ru.gb.lesson4.hw.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATest");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}

package sr.unasat.ecom.bp.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfiguration {
    private static final String PERSISTENCE_UNIT_NAME = "my-persistence";
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    // Private constructor to prevent instantiation
    private JPAConfiguration() {
    }

    // Static method to get the instance of EntityManagerFactory
    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    // Static method to get the instance of EntityManager
    public static synchronized EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    // Static method to shut down the EntityManagerFactory
    public static synchronized void shutdown() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
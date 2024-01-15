package sr.unasat.ecom.bp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.ecom.bp.entities.User;

import java.util.List;

public class UserRepository {
    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User createUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return user;
    }

    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    public User updateUser(User updatedUser) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(updatedUser);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return updatedUser;
    }

    public void deleteUser(int userId) {
        try {
            entityManager.getTransaction().begin();
            User userToDelete = entityManager.find(User.class, userId);
            if (userToDelete != null) {
                entityManager.remove(userToDelete);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    // Additional method to get all users
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}

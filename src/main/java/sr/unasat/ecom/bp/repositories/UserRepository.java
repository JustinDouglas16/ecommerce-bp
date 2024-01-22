package sr.unasat.ecom.bp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sr.unasat.ecom.bp.entities.Order;
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

    public List<User> getUserWithOrdersAndProducts(int userId) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u LEFT JOIN FETCH u.orders o LEFT JOIN FETCH o.products WHERE u.id = :userId",
                User.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Order> getOrdersWithProductsForUser(int userId) {
        TypedQuery<Order> query = entityManager.createQuery(
                "SELECT o FROM Order o LEFT JOIN FETCH o.products WHERE o.user.id = :userId",
                Order.class
        );
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public Double getTotalPriceForOrder(int orderId) {
        try {
            entityManager.getTransaction().begin();

            // The JPQL query to calculate the total price for one specific order
            String jpql = "SELECT SUM(p.price) FROM Order o JOIN o.products p WHERE o.id = :orderId";

            // Create a typed query using the EntityManager
            TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
            query.setParameter("orderId", orderId);

            // Execute the query and get the result
            Double totalPrice = query.getSingleResult();

            entityManager.getTransaction().commit();

            return totalPrice;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }
}

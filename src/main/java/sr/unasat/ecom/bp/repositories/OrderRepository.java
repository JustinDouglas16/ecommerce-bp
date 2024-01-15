package sr.unasat.ecom.bp.repositories;

import jakarta.persistence.EntityManager;
import sr.unasat.ecom.bp.entities.Order;

import java.util.List;

public class OrderRepository {
    private EntityManager entityManager;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Order createOrder(Order order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return order;
    }

    public Order getOrderById(int orderId) {
        return entityManager.find(Order.class, orderId);
    }

    public Order updateOrder(Order updatedOrder) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(updatedOrder);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return updatedOrder;
    }

    public void deleteOrder(int orderId) {
        try {
            entityManager.getTransaction().begin();
            Order orderToDelete = entityManager.find(Order.class, orderId);
            if (orderToDelete != null) {
                entityManager.remove(orderToDelete);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<Order> getAllOrders() {
        return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }
}

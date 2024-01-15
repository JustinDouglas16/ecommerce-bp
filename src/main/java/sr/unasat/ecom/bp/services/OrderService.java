package sr.unasat.ecom.bp.services;

import sr.unasat.ecom.bp.config.JPAConfiguration;
import sr.unasat.ecom.bp.entities.Order;
import sr.unasat.ecom.bp.repositories.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository repository;

    public OrderService() {
        this.repository = new OrderRepository(JPAConfiguration.getEntityManager());
    }

    public Order createOrder(Order order) {
        return repository.createOrder(order);
    }

    public Order getOrderById(int orderId) {
        return repository.getOrderById(orderId);
    }

    public Order updateOrder(Order updatedOrder) {
        return repository.updateOrder(updatedOrder);
    }

    public void deleteOrder(int orderId) {
        repository.deleteOrder(orderId);
    }

    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }
}

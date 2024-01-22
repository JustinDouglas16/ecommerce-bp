package sr.unasat.ecom.bp.services;

import sr.unasat.ecom.bp.config.JPAConfiguration;
import sr.unasat.ecom.bp.entities.Order;
import sr.unasat.ecom.bp.entities.User;
import sr.unasat.ecom.bp.repositories.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        this.repository = new UserRepository(JPAConfiguration.getEntityManager());
    }

    public User createUser(User user) {
        return repository.createUser(user);
    }

    public User getUserById(int userId) {
        return repository.getUserById(userId);
    }

    public User updateUser(User updatedUser) {
        return repository.updateUser(updatedUser);
    }

    public void deleteUser(int userId) {
        repository.deleteUser(userId);
    }

    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    public List<User> getUserWithOrdersAndProducts(int userId) {
        return repository.getUserWithOrdersAndProducts(userId);
    }

    public List<Order> getOrdersWithProductsForUser(int userId) {
        return repository.getOrdersWithProductsForUser(userId);
    }

    public Double getTotalPriceForOrder(int orderId) {
        return repository.getTotalPriceForOrder(orderId);
    }

    public Double getTotalPriceForAllOrdersOfUser(int userId) {
        return repository.getTotalPriceForAllOrdersOfUser(userId);
    }
}

package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.services.UserService;

public class ViewAllOrdersWithProductsCommand implements Command {
    private final UserService userService;

    public ViewAllOrdersWithProductsCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        userService.getAllUsers().forEach(user -> {
            System.out.println("User with the order: " + user.getFirstname() + " " + user.getLastname());
            user.getOrders().forEach(order -> {
                System.out.println("Order ID: " + order.getId());
                order.getProducts().forEach(product ->
                        System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName()));
            });
        });
    }
}

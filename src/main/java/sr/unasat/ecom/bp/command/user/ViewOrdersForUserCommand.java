package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewOrdersForUserCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public ViewOrdersForUserCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the ID of the user to view orders: ");
            int userId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            userService.getOrdersWithProductsForUser(userId).forEach(order -> {
                System.out.println("Order ID: " + order.getId());
                order.getProducts().forEach(product ->
                        System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName()));
            });

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid user ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

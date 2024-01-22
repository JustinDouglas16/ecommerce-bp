package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewTotalPriceForOrderCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public ViewTotalPriceForOrderCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the ID of the order to view total price: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Double totalPrice = userService.getTotalPriceForOrder(orderId);

            if (totalPrice != null) {
                System.out.println("Total price for Order ID " + orderId + ": " + totalPrice);
            } else {
                System.out.println("Failed to retrieve total price for Order ID " + orderId);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid order ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}
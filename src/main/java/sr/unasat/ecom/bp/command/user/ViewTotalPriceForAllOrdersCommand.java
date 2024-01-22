package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewTotalPriceForAllOrdersCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public ViewTotalPriceForAllOrdersCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the ID of the user to view total price for all orders: ");
            int userId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Double totalPrice = userService.getTotalPriceForAllOrdersOfUser(userId);

            if (totalPrice != null) {
                System.out.println("Total price for all orders of User ID " + userId + ": " + totalPrice);
            } else {
                System.out.println("Failed to retrieve total price for all orders of User ID " + userId);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid user ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}
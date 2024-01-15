package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.User;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewUserByIdCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public ViewUserByIdCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter User ID: ");
        try {
            int userId = scanner.nextInt();
            User user = userService.getUserById(userId);
            if (user != null) {
                System.out.println("User Details:");
                System.out.println("ID: " + user.getId());
                System.out.println("First Name: " + user.getFirstname());
                System.out.println("Last Name: " + user.getLastname());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
            } else {
                System.out.println("User not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

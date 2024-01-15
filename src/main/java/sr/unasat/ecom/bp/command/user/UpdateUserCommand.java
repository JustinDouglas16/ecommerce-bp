package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.User;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateUserCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public UpdateUserCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter User ID to update: ");
        try {
            int userId = scanner.nextInt();
            User existingUser = userService.getUserById(userId);
            if (existingUser != null) {
                scanner.nextLine();
                System.out.println("Enter updated user details:");
                System.out.print("First Name: ");
                existingUser.setFirstname(scanner.nextLine());
                System.out.print("Last Name: ");
                existingUser.setLastname(scanner.nextLine());
                System.out.print("Username: ");
                existingUser.setUsername(scanner.nextLine());
                System.out.print("Email: ");
                existingUser.setEmail(scanner.nextLine());
                System.out.print("Password: ");
                existingUser.setPassword(scanner.nextLine());

                userService.updateUser(existingUser);
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

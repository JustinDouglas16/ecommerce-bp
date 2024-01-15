package sr.unasat.ecom.bp.command.user;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteUserCommand implements Command {
    private final UserService userService;
    private final Scanner scanner;

    public DeleteUserCommand(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter User ID to delete: ");
        try {
            int userId = scanner.nextInt();
            userService.deleteUser(userId);
            System.out.println("User deleted successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

package sr.unasat.ecom.bp.command;

import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConsoleInterface {
    private final UserCommandInvoker commandInvoker;

    public UserConsoleInterface(UserService userService, Scanner scanner) {
        this.commandInvoker = new UserCommandInvoker(userService, scanner);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== User Management System ====");
            System.out.println("1. Create User");
            System.out.println("2. View User by ID");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. View All Users");
            System.out.println("6. View All Orders with Products (New Option)");
            System.out.println("7. View Orders for a Specific User (New Option)");
            System.out.println("8. View Total Price for a Specific Order (New Option)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                commandInvoker.executeCommand(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0;
            }

        } while (choice != 9);

        System.out.println("Exiting...");
    }
}
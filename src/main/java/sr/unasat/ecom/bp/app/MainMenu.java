package sr.unasat.ecom.bp.app;

import sr.unasat.ecom.bp.command.ProductConsoleInterface;
import sr.unasat.ecom.bp.command.UserConsoleInterface;
import sr.unasat.ecom.bp.services.ProductService;
import sr.unasat.ecom.bp.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private final UserService userService;
    private final ProductService productService;
    private final Scanner scanner;

    public MainMenu(UserService userService, ProductService productService, Scanner scanner) {
        this.userService = userService;
        this.productService = productService;
        this.scanner = scanner;
    }

    public void start() {
        int choice;

        do {
            System.out.println("==== Main Menu ====");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        manageUsers();
                        break;
                    case 2:
                        manageProducts();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0;
            }

        } while (choice != 3);
    }

    private void manageUsers() {
        UserConsoleInterface userConsoleInterface = new UserConsoleInterface(userService, scanner);
        userConsoleInterface.start();
    }

    private void manageProducts() {
        ProductConsoleInterface productConsoleInterface = new ProductConsoleInterface(productService, scanner);
        productConsoleInterface.start();
    }
}

package sr.unasat.ecom.bp.command;

import sr.unasat.ecom.bp.services.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductConsoleInterface {
    private final ProductCommandInvoker commandInvoker;

    public ProductConsoleInterface(ProductService productService, Scanner scanner) {
        this.commandInvoker = new ProductCommandInvoker(productService, scanner);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== Product Management System ====");
            System.out.println("1. Create Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. View All Products");
            System.out.println("6. Exit");
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

        } while (choice != 6);

        System.out.println("Exiting...");
    }
}

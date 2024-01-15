package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteProductCommand implements Command {
    private final ProductService productService;
    private final Scanner scanner;

    public DeleteProductCommand(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Product ID to delete: ");
        try {
            int productId = scanner.nextInt();
            productService.deleteProduct(productId);
            System.out.println("Product deleted successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

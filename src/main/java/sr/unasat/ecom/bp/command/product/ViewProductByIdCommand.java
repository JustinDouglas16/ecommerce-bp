package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewProductByIdCommand implements Command {
    private final ProductService productService;
    private final Scanner scanner;

    public ViewProductByIdCommand(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Product ID: ");
        try {
            int productId = scanner.nextInt();
            Product product = productService.getProductById(productId);
            if (product != null) {
                System.out.println("Product Details:");
                System.out.println("ID: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
            } else {
                System.out.println("Product not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

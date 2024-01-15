package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateProductCommand implements Command {
    private final ProductService productService;
    private final Scanner scanner;

    public UpdateProductCommand(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Product ID to update: ");
        try {
            int productId = scanner.nextInt();
            Product existingProduct = productService.getProductById(productId);
            if (existingProduct != null) {
                System.out.println("Enter updated product details:");
                scanner.nextLine();
                System.out.print("Product Name: ");
                existingProduct.setName(scanner.nextLine());
                System.out.print("Price: ");
                existingProduct.setPrice(scanner.nextDouble());
                System.out.print("Quantity: ");
                existingProduct.setQuantity(scanner.nextInt());

                productService.updateProduct(existingProduct);
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

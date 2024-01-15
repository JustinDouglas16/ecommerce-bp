package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.Scanner;

public class CreateProductCommand implements Command {
    private final ProductService productService;
    private final Scanner scanner;

    public CreateProductCommand(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter product details:");
        scanner.nextLine();
        System.out.print("Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setQuantity(quantity);

        productService.createProduct(newProduct);
        System.out.println("Product created successfully.");
    }
}

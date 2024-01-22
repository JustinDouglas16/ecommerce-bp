package sr.unasat.ecom.bp.command;

import sr.unasat.ecom.bp.command.product.*;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductCommandInvoker {
    private final Map<Integer, Command> commands = new HashMap<>();

    public ProductCommandInvoker(ProductService productService, Scanner scanner) {
        commands.put(1, new CreateProductCommand(productService, scanner));
        commands.put(2, new ViewProductByIdCommand(productService, scanner));
        commands.put(3, new UpdateProductCommand(productService, scanner));
        commands.put(4, new DeleteProductCommand(productService, scanner));
        commands.put(5, new ViewAllProductsCommand(productService));
        commands.put(6, new ViewAllProductsAscByPriceCommand(productService));
        commands.put(7, new ViewAllProductsDescByPriceCommand(productService));
        commands.put(8, new ViewAllProductsAscByQuantityCommand(productService));
        commands.put(9, new ViewAllProductsDescByQuantityCommand(productService));
    }

    public void executeCommand(int choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid choice. Please choose a number between 1 and 5.");
        }
    }
}

package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.List;

public class ViewAllProductsCommand implements Command {
    private final ProductService productService;

    public ViewAllProductsCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            System.out.println("All Products:");
            for (Product product : products) {
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName());
            }
        } else {
            System.out.println("No products found.");
        }
    }
}

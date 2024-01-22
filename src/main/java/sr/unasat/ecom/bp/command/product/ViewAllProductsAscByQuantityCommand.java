package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.List;

public class ViewAllProductsAscByQuantityCommand implements Command {
    private final ProductService productService;

    public ViewAllProductsAscByQuantityCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        List<Product> products = productService.getAllProductsAscByQuantity();
        displayProducts(products);
    }

    private void displayProducts(List<Product> products) {
        if (!products.isEmpty()) {
            System.out.println("All Products in Ascending Order by Quantity:");
            for (Product product : products) {
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity());
            }
        } else {
            System.out.println("No products found.");
        }
    }
}

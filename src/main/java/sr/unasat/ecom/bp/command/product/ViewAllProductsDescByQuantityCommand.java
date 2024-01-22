package sr.unasat.ecom.bp.command.product;

import sr.unasat.ecom.bp.command.Command;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.services.ProductService;

import java.util.List;

public class ViewAllProductsDescByQuantityCommand implements Command {
    private final ProductService productService;

    public ViewAllProductsDescByQuantityCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        List<Product> products = productService.getAllProductsDescByQuantity();
        displayProducts(products);
    }

    private void displayProducts(List<Product> products) {
        if (!products.isEmpty()) {
            System.out.println("All Products in Descending Order by Quantity:");
            for (Product product : products) {
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity());
            }
        } else {
            System.out.println("No products found.");
        }
    }
}
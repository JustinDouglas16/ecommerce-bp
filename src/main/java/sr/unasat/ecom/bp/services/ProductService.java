package sr.unasat.ecom.bp.services;

import sr.unasat.ecom.bp.config.JPAConfiguration;
import sr.unasat.ecom.bp.entities.Product;
import sr.unasat.ecom.bp.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService() {
        this.repository = new ProductRepository(JPAConfiguration.getEntityManager());
    }

    public Product createProduct(Product product) {
        return repository.createProduct(product);
    }

    public Product getProductById(int productId) {
        return repository.getProductById(productId);
    }

    public Product updateProduct(Product updatedProduct) {
        return repository.updateProduct(updatedProduct);
    }

    public void deleteProduct(int productId) {
        repository.deleteProduct(productId);
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    // Method to get all products in ascending order based on the product name
    public List<Product> getAllProductsAsc() {
        return repository.getAllProductsAsc();
    }

    // Method to get all products in descending order based on the product name
    public List<Product> getAllProductsDesc() {
        return repository.getAllProductsDesc();
    }

    // Method to get all products in ascending order based on the product price
    public List<Product> getAllProductsAscByPrice() {
        return repository.getAllProductsAscByPrice();
    }

    // Method to get all products in descending order based on the product price
    public List<Product> getAllProductsDescByPrice() {
        return repository.getAllProductsDescByPrice();
    }

    // Method to get all products in ascending order based on the product quantity
    public List<Product> getAllProductsAscByQuantity() {
        return repository.getAllProductsAscByQuantity();
    }

    // Method to get all products in descending order based on the product quantity
    public List<Product> getAllProductsDescByQuantity() {
        return repository.getAllProductsDescByQuantity();
    }
}

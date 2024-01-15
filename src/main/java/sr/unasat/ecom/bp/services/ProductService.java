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
}

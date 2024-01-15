package sr.unasat.ecom.bp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.unasat.ecom.bp.entities.Product;

import java.util.List;

public class ProductRepository {
    private EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product createProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return product;
    }

    public Product getProductById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    public Product updateProduct(Product updatedProduct) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(updatedProduct);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return updatedProduct;
    }

    public void deleteProduct(int productId) {
        try {
            entityManager.getTransaction().begin();
            Product productToDelete = entityManager.find(Product.class, productId);
            if (productToDelete != null) {
                entityManager.remove(productToDelete);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    // Additional method to get all products
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}

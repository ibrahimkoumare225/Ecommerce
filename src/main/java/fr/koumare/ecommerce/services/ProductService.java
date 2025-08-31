package fr.koumare.ecommerce.services;

import fr.koumare.ecommerce.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Long id);
    public Product updateProduct(Product product);
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public void deleteProduct(Long id);
}

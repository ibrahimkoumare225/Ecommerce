package fr.koumare.ecommerce.services.impl;

import fr.koumare.ecommerce.models.Categorie;
import fr.koumare.ecommerce.models.Product;
import fr.koumare.ecommerce.repository.CategorieRepository;
import fr.koumare.ecommerce.repository.ProductRepository;
import fr.koumare.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final CategorieRepository categorieRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getProduct_id()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        if(product.getName() != null){
            existingProduct.setName(product.getName());
        }
        if (product.getPrice()!= null){
            existingProduct.setPrice(product.getPrice());
        }
        if(product.getCategorie() != null){
            existingProduct.setCategorie(product.getCategorie());
        }
        return productRepository.save(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Override
    public Product addProduct(Product product) {
        if(product.getCategorie()!=null && product.getCategorie().getId()!=null){
            Optional<Categorie> categorieOpt = categorieRepository.findById(product.getCategorie().getId());
            categorieOpt.ifPresent(product::setCategorie);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

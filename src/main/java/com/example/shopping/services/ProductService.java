package com.example.shopping.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.shopping.models.Product;
import com.example.shopping.repositories.ProductRepository;

@Service
public class ProductService {
    
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> getProduct(long id) {
        return this.productRepository.findById(id);
    }

    public Product deleteProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Product updateProduct(long id, Product product) {
        Product oldProduct = this.productRepository.findById(id).get();
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        this.productRepository.save(oldProduct);
        return oldProduct;
    }

}

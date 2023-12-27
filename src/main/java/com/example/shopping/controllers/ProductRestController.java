package com.example.shopping.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopping.models.Product;
import com.example.shopping.services.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(this.productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@Valid @RequestParam long id) {
        return new ResponseEntity<>(this.productService.getProduct(id), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Product> updateProduct(@Valid @RequestParam long id, @Valid @RequestBody Product product) {
        return new ResponseEntity<>(this.productService.updateProduct(id, product), HttpStatus.CREATED);
    }

}

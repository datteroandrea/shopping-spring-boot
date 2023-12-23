package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

@Entity
public class ProductOrder {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="product_order_id")
    private long id;

    @Min(value = 1)
    public int quantity;

    public Product product;

}

package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

@Entity
public class ProductOrder {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="product_order_id")
    private long id;

    @Min(value = 1) // Ensures quantity is at least 1
    private int quantity;

    @ManyToOne
    private Product product; // This assumes each ProductOrder relates to one Product

    @ManyToOne
    private Order order;

    // standard getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

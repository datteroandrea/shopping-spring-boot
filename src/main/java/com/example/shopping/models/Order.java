package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="order_id")
    private Long id;
    
    @ManyToOne
    private Account account;

    @OneToMany(mappedBy = "order") // Make sure 'order' matches the field in the ProductOrder that refers back to this Order
    private List<ProductOrder> products = new ArrayList<>();

    // standard getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> orderedProducts) {
        this.products = orderedProducts;
    }
}

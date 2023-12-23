package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="product_id")
    private Long id;

    @ManyToMany(targetEntity=com.example.shopping.models.Product.class)
    private Iterable<Order> orders;
}

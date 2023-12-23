package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="order_id")
    private Long id;
    
    @ManyToMany(targetEntity=com.example.shopping.models.Order.class)
    private Iterable<Product> products;
}

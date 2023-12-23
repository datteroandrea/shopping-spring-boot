package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")

public class Account {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="account_id")
    private Long id;

    public String name;

    public String email;

    @OneToMany(targetEntity=com.example.shopping.models.Order.class)
    public Iterable<Order> orders;

}

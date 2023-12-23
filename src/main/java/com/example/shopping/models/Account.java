package com.example.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")

public class Account {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="account_id")
    private Long id;

}

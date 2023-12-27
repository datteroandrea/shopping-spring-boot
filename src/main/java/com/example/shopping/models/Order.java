package com.example.shopping.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @OneToMany(mappedBy = "order")
    private List<OrderedProduct> orderedProducts;

    public Order() {
        
    }

    public Order(Date dateCreated, List<OrderedProduct> orderedProducts) {
        this.dateCreated = dateCreated;
        this.orderedProducts = orderedProducts;
    }
    
    public Long getId() {
        return this.id;
    }

    public Account getAccount() {
        return this.account;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public List<OrderedProduct> getProducts() {
        return this.orderedProducts;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

}
package com.example.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.shopping.models.OrderedProduct;

@Repository
public interface ProductOrderRepository extends JpaRepository<OrderedProduct, Long> {
    
}

package com.example.shopping.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopping.models.Order;
import com.example.shopping.models.ProductOrder;
import com.example.shopping.repositories.OrderRepository;
import com.example.shopping.repositories.ProductOrderRepository;
import jakarta.validation.Valid;

// TODO: remove usage of repository and subsitute it with a call to the services
@RestController("/orders")
public class OrderRestController {

    private ProductOrderRepository productOrderRepository;
    private OrderRepository orderRepository;
    
    @PostMapping("/{accountId}/create")
    public ResponseEntity<Order> createOrder(@Valid @RequestParam long accountId, @Valid @RequestBody Iterable<ProductOrder> products) {
        Iterable<ProductOrder> orderedProducts = this.productOrderRepository.saveAll(products);
        Order order = new Order();
        order.accountId = accountId;
        order.products = orderedProducts;
        return new ResponseEntity<>(this.orderRepository.save(order), HttpStatus.CREATED);
    }

}

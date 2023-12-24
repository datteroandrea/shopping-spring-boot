package com.example.shopping.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopping.models.Order;
import com.example.shopping.models.ProductOrder;
import com.example.shopping.services.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private OrderService orderService;
    
    @PostMapping("/{accountId}/create")
    public ResponseEntity<Order> createOrder(@Valid @RequestParam long accountId, @Valid @RequestBody List<ProductOrder> products) {
        Order order = this.orderService.createOrder(accountId, products);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}

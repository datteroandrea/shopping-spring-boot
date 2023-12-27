package com.example.shopping.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopping.models.Order;
import com.example.shopping.models.OrderedProduct;
import com.example.shopping.services.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping("/{accountId}/create")
    public ResponseEntity<Order> createOrder(@Valid @RequestParam Long accountId, @Valid @RequestBody List<OrderedProduct> orderedProducts) throws Exception {
        Order order = this.orderService.createOrder(accountId, orderedProducts);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}

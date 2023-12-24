package com.example.shopping.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.shopping.models.Order;
import com.example.shopping.repositories.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public Optional<Order> getOrder(long id) {
        return this.orderRepository.findById(id);
    }

    public void deleteOrder(long id) {
        this.orderRepository.deleteById(id);
    }

}

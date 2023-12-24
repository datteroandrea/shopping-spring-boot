package com.example.shopping.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.shopping.models.Order;
import com.example.shopping.models.ProductOrder;
import com.example.shopping.repositories.OrderRepository;
import com.example.shopping.repositories.ProductOrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductOrderRepository productOrderRepository;

    public Order createOrder(long accountId, List<ProductOrder> products) {
        List<ProductOrder> orderedProducts = this.productOrderRepository.saveAll(products);
        Order order = new Order();
        order.setProducts(orderedProducts);
        return this.orderRepository.save(order);
    }

    public Optional<Order> getOrder(long id) {
        return this.orderRepository.findById(id);
    }

    public void deleteOrder(long id) {
        this.orderRepository.deleteById(id);
    }

}

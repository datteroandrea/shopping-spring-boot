package com.example.shopping.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shopping.models.Account;
import com.example.shopping.models.Order;
import com.example.shopping.models.OrderedProduct;
import com.example.shopping.repositories.OrderRepository;
import com.example.shopping.repositories.ProductOrderRepository;

@Service
public class OrderService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    public Order createOrder(Long accountId, List<OrderedProduct> orderedProducts) throws Exception {
        Optional<Account> accountOptional = this.accountService.getAccount(accountId);

        if (accountOptional.isEmpty()) {
            throw new Exception("Account not found for ID: " + accountId);
        }

        Account account = accountOptional.get();

        if (orderedProducts.isEmpty()) {
            throw new IllegalArgumentException("Ordered products list cannot be empty.");
        }

        // Create the order without orderedProducts and save it to generate the ID
        Order order = new Order(new Date(), null);
        order.setAccount(account);
        order = this.orderRepository.save(order);

        // Associate the order with OrderedProducts
        for (OrderedProduct orderedProduct : orderedProducts) {
            orderedProduct.setOrder(order);
        }

        // Save the OrderedProducts (this should be wrapped in a transaction)
        List<OrderedProduct> savedOrderedProducts = this.productOrderRepository.saveAll(orderedProducts);

        // Set the saved OrderedProducts in the Order
        order.setProducts(savedOrderedProducts);

        // Save the order again with the associated OrderedProducts
        order = this.orderRepository.save(order);

        return order;
    }

    public Optional<Order> getOrder(long id) {
        return this.orderRepository.findById(id);
    }

    public void deleteOrder(long id) {
        this.orderRepository.deleteById(id);
    }

}

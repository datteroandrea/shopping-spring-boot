package com.example.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import java.util.List;
import com.example.shopping.models.Account;
import com.example.shopping.models.Product;
import com.example.shopping.repositories.AccountRepository;
import com.example.shopping.repositories.ProductRepository;

@SpringBootApplication
public class ShoppingApplication {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            System.out.println("Running.....");

			// create products, accounts and orders and save them in the db
            Product product = new Product("Ear Buds", 99.99f);

            Product product1 = new Product("ThinkPad", 999.99f);

            Account account = new Account("Andrea D'Attero", "testshoppingmail@gmail.com");

            accountRepository.save(account);

            productRepository.saveAll(List.of(product, product1));
        };
    }

}

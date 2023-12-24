package com.example.shopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            System.out.println("Running.....");

			// create products, accounts and orders and save them in the db

        };
    }

}

package com.example.shopping.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApiInformation() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Localhost Server URL");

        Contact contact = new Contact()
                .email("test@gmail.com")
                .name("Andrea D'Attero");

        Info info = new Info()
                .contact(contact)
                .description("Spring Boot 3 + Open API 3")
                .summary("Demo of Spring Boot 3 & Open API 3 Integration")
                .title("Spring Boot 3 + Open API 3")
                .version("V1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        return new OpenAPI().info(info).addServersItem(localServer);
    }
}
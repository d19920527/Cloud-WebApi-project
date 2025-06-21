package com.wei.webapi.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("2025 API Documentation - 2025電影訂票範例")
                        .description("SpringBoot 3.5 application")
                        .version("v0.0.1")
                        .license(new License().name("Your License").url("http://springdoc.org"))
                        .contact(new Contact().name("Ian Liu").email("ianliu@example.com").url("Your Website URl"))
                );
    }
}
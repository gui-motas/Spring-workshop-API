package com.gui_motas.workshop_spring_jpa.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Configuration
@Controller
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().servers(List.of(new Server().url("https://workshop-spring-jpa.fly.dev")))
                .info(new Info()
                        .title("API REST - Spring Boot com JPA")
                        .version("1.0.0")
                        .description("Este projeto é uma API RESTful construída com Spring Boot, seguindo uma arquitetura baseada em camadas para organizar as responsabilidades do sistema. A aplicação permite operações básicas de CRUD (Create, Read, Update, Delete) e utiliza PostgreSQL para persistência dos dados."));
    }

    @GetMapping("/")
    public RedirectView redirectToSwaggerUi() {
        return new RedirectView("/swagger-ui/index.html");
    }


}

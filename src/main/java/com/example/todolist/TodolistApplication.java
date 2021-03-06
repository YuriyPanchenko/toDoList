package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodolistApplication {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins(
                                "https://react-todoapp-lq7.herokuapp.com",
                                "https://liquidcore7.localtunnel.me",
                                "http://localhost:4200/"
                        )
                        .allowedMethods("*");
            }
        };
        return webMvcConfigurer;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);
    }

}

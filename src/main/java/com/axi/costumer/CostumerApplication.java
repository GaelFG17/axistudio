package com.axi.costumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.axi.costumer")
public class CostumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumerApplication.class, args);
    }
}
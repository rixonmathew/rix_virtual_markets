package com.rixon.virtualmarket.institution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rixon.virtualmarket")
public class InstitutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstitutionApplication.class,args);
    }
}

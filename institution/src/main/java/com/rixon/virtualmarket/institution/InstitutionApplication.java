package com.rixon.virtualmarket.institution;

import com.rixon.virtualmarket.institution.models.InstitutionPositions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rixon.virtualmarket")
public class InstitutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstitutionApplication.class,args);
    }

    @Bean
    public InstitutionPositions institutionPositions() {
        InstitutionPositions institutionPositions = new InstitutionPositions();
        return institutionPositions;
    }
}

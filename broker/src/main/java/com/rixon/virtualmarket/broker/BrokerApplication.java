package com.rixon.virtualmarket.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class BrokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class,args);
    }

}

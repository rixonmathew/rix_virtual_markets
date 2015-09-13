package com.rixon.virtualmarket.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/rix_broker")
public class BrokerApplication {


    @RequestMapping
    public String home() {
        return "I am a prime broker";
    }

    public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class,args);
    }

}

package com.rixon.virtualmarket.broker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/rix_broker")
public class BrokerApplication {


    @RequestMapping
    public String home() {
        return "I am a broker";
    }

    public static void main(String[] args) {
        SpringApplication.run(BrokerApplication.class,args);
    }

}

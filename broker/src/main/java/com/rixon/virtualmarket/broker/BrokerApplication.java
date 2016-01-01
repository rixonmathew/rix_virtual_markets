package com.rixon.virtualmarket.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BrokerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BrokerApplication.class, args);
  }

}

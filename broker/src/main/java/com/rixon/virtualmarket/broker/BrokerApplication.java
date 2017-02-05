package com.rixon.virtualmarket.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("${secure_property_file}")
public class BrokerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BrokerApplication.class, args);
  }

}

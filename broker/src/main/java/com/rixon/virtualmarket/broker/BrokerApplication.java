package com.rixon.virtualmarket.broker;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;

@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("${secure_property_file}")
public class BrokerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BrokerApplication.class, args);
  }

//  @Bean
//  public PropertyPlaceholderConfigurer secureProperties() {
//    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer= new PropertyPlaceholderConfigurer();
//    ResourceLoader resourceLoader = new DefaultResourceLoader(ClassUtils.getDefaultClassLoader());
//    propertyPlaceholderConfigurer.setLocations(resourceLoader.getResource("file:/tmp/secure/broker-service/secure_props.properties"));
//    return propertyPlaceholderConfigurer;
//  }

}

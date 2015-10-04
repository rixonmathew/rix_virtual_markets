package com.rixon.virtualmarket.institution.service;

import com.rixon.virtualmarket.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BrokerService {
    private String placeOrderEndpoint;
    private RestTemplate placeOrderTemplate;

    @Autowired
    public BrokerService(@Value("${broker.order.endpoint}") String placeOrderEndpoint) {
        this.placeOrderEndpoint = placeOrderEndpoint;
        placeOrderTemplate = new RestTemplate();
    }

    public void placeOrder(Order order) {
        placeOrderTemplate.postForLocation(placeOrderEndpoint,order);
    }

    public String getPlaceOrderEndpoint() {
        return placeOrderEndpoint;
    }

    public void setPlaceOrderEndpoint(String placeOrderEndpoint) {
        this.placeOrderEndpoint = placeOrderEndpoint;
    }
}

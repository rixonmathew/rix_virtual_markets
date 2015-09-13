package com.rixon.virtualmarket.broker.controller;

import com.rixon.virtualmarket.broker.models.OrderResponse;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("${order.endpoint}")
public class OrderController {

    @RequestMapping
    public String home() {
        return "I am a prime broker";
    }

    @RequestMapping(name = "${place.order}",
                    method = RequestMethod.POST,
                    headers = {"Content-Type=application/json"})
    public @ResponseBody OrderResponse acceptOrder(@RequestBody Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("Success for " + order.toString());
        orderResponse.setDateTime(LocalDateTime.now());
        return orderResponse;
    }

}

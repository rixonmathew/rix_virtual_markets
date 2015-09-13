package com.rixon.virtualmarket.broker.controller;

import com.rixon.virtualmarket.broker.models.OrderResponse;
import com.rixon.virtualmarket.order.Order;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("${order.endpoint}")
public class OrderController {

    @RequestMapping
    public String home() {
        return "I am a prime broker";
    }

    @RequestMapping(path = "${place.order}",
                    method = RequestMethod.POST,
                    headers = {"Content-Type=application/json;charset=UTF-8"})
    public @ResponseBody OrderResponse acceptOrder(@RequestBody Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("Success for " + order.toString());
        orderResponse.setDateTime(LocalDateTime.now());
        return orderResponse;
    }

}

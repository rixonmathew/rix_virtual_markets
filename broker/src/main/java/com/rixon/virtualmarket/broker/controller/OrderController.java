package com.rixon.virtualmarket.broker.controller;

import com.rixon.virtualmarket.broker.models.OrderResponse;
import com.rixon.virtualmarket.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("${broker.endpoint}")
public class OrderController {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping
    public String home() {
        LOGGER.info("Got home call in BrokerController");
        return "I am a prime broker";
    }

    @RequestMapping(path = "${broker.place.order}",
                    method = RequestMethod.POST,
                    headers = {"Content-Type=application/json;charset=UTF-8"})
    public @ResponseBody OrderResponse acceptOrder(@RequestBody Order order) {
        LOGGER.info("Got accept order call [{}]",order);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("Success for " + order.toString());
        orderResponse.setDateTime(LocalDateTime.now());
        return orderResponse;
    }

}

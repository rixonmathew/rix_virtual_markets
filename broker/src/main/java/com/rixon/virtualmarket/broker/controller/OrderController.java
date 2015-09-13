package com.rixon.virtualmarket.broker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rixonmathew on 13/09/15.
 */
@RestController
@RequestMapping("${order.endpoint}")
public class OrderController {

    @RequestMapping
    public String home() {
        return "I am a prime broker";
    }

}

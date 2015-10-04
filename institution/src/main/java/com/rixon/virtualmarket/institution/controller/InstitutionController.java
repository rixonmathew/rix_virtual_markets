package com.rixon.virtualmarket.institution.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${institution.endpoint}")
public class InstitutionController {

    @Value("${institution.name}")
    private String name;

    @RequestMapping
    public String home() {
        return "I am an institution "+name;
    }

    /*
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
    */


}

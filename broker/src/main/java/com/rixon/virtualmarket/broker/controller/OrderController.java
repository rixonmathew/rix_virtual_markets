package com.rixon.virtualmarket.broker.controller;

import com.rixon.virtualmarket.broker.models.OrderResponse;
import com.rixon.virtualmarket.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("${broker.endpoint:/rvm_broker}")
public class OrderController {

  private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

  @Value("${broker.secure.property1.password:password123}")
  private String secureProperty1;
  @Value("${broker.secure.property2.password:password123}")
  private String secureProperty2;

  @RequestMapping
  public String home() {
    LOGGER.info("Got home call in BrokerController");
    return "I am a prime broker";
  }
  @RequestMapping(path = "${broker.get.order:/order}",
      method = RequestMethod.GET,
      headers = {"Content-Type=application/json;charset=UTF-8"})
  public @ResponseBody Order getOrder(@RequestParam("orderId") String orderId) {
    //TODO add OrderService that works with OrderRepository to return Order status
    return new Order();
  }


  @RequestMapping(path = "${broker.place.order:/order}",
      method = RequestMethod.POST,
      headers = {"Content-Type=application/json;charset=UTF-8"})
  public
  @ResponseBody
  OrderResponse acceptOrder(@RequestBody Order order) {
    LOGGER.info("Got accept order call [{}]", order);
    //TODO check local order book to see if this order can be matched. If not call exchange-service to place order.
    OrderResponse orderResponse = new OrderResponse();
    orderResponse.setStatus("Success for " + order.toString());
    orderResponse.setDateTime(LocalDateTime.now());
    return orderResponse;
  }

}

package com.rixon.virtualmarket.exchange.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * This class represents the controllers for handling requests related to Orders
 * User: rixon
 * Date: 19/8/13
 * Time: 1:44 PM
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderHandler orderHandler;

    @RequestMapping(method = RequestMethod.POST,
                    headers = {"Content-Type=application/json"})
    public @ResponseBody OrderResponse handleOrder(@RequestBody Order order) {
        return orderHandler.placeOrder(order);
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    headers = {"Accept=application/xml,application/json"})
    public @ResponseBody Order get(@PathVariable String id) {
        return orderHandler.getOrderForId(id);
    }

    private String responseAsJSON(OrderResponse orderResponse){
        PropertyFilter filter = new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                if (name.equals("orderOK")){
                    return false;
                }
                return true;
            }
        };
        SerializerFeature[] features = {SerializerFeature.UseISO8601DateFormat,
                SerializerFeature.SortField,
                SerializerFeature.WriteNullListAsEmpty
        };
        return JSON.toJSONString(orderResponse, filter, features);
    }
}

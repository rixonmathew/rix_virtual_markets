package com.rixon.virtualmarket.exchange.order.handler;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;

/**
 * This class is responsible for handling the Orders in the exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 2:42 PM
 */
public class OrderHandler {
    public String placeOrder(String orderString) {
        Order order = JSON.parseObject(orderString, Order.class);
        boolean isOrderOK = validateOrder(order);
        OrderResponse orderResponse = null;
        if (!isOrderOK) {
            orderResponse = populateErrorResponse(order);
        }
        orderResponse = createOrder(order);
        return JSON.toJSONString(orderResponse);
    }

    private boolean validateOrder(Order order) {
        return true;
    }

    private OrderResponse populateErrorResponse(Order order) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }


    private OrderResponse createOrder(Order order) {
        //TODO add logic to persist the order in store.
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("OK");
        orderResponse.setOrderID(order.getOrderID());
        return orderResponse;
    }

}

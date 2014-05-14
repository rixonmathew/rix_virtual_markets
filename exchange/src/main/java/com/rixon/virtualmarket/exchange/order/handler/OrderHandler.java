package com.rixon.virtualmarket.exchange.order.handler;

import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.exchange.order.repository.OrderRepository;
import com.rixon.virtualmarket.exchange.order.validator.OrderValidator;
import com.rixon.virtualmarket.exchange.order.validator.OrderValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for handling the Orders in the exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 2:42 PM
 */
@Service
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    public OrderResponse placeOrder(Order order) {
        OrderResponse orderResponse = createTemplateResponse(order);
        validateOrder(order,orderResponse);
        if (isOrderOK(orderResponse)) {
            orderRepository.save(order);
            updateResponse(order, orderResponse);
        }
        return orderResponse;
    }

    private boolean isOrderOK(OrderResponse orderResponse) {
        return orderResponse.getStatus().equals("OK");
    }

    private OrderResponse createTemplateResponse(Order order) {
        //TODO think about fields that could be populated from order
        return new OrderResponse();
    }

    private void validateOrder(Order order,OrderResponse orderResponse) {
        OrderValidator orderValidator = OrderValidatorFactory.validatorForOrder(order);
        orderValidator.validate(order,orderResponse);
    }

    private void updateResponse(Order order,OrderResponse orderResponse) {
        orderResponse.setStatus("OK");
        orderResponse.setOrderID(order.getOrderID());
    }

    public Order getOrderForId(String orderId) {
        return orderRepository.findOne(orderId);
    }

    public OrderResponse delete(String orderID) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderID(orderID);
        if (orderID!=null) {
            orderRepository.delete(orderID);
            orderResponse.setStatus("OK");
        } else {
            orderResponse.setStatus("NOK");
        }
        return orderResponse;
    }
}
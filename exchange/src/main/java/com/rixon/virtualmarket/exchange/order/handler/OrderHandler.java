package com.rixon.virtualmarket.exchange.order.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.exchange.order.validator.OrderValidator;
import com.rixon.virtualmarket.exchange.order.validator.OrderValidatorFactory;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for handling the Orders in the exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 2:42 PM
 */
@Service
public class OrderHandler {

    public OrderResponse placeOrder(Order order) {
        OrderResponse orderResponse = createTemplateResponse(order);
        validateOrder(order,orderResponse);
        if (isOrderOK(orderResponse)) {
            updateResponse(order,orderResponse);
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
}
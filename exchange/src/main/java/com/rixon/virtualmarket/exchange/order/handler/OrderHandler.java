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

/**
 * This class is responsible for handling the Orders in the exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 2:42 PM
 */
public class OrderHandler {
    public String placeOrder(String orderString) {
        Order order = JSON.parseObject(orderString, Order.class);
        OrderResponse orderResponse = createTemplateResponse(order);
        validateOrder(order,orderResponse);
        if (orderResponse.isOrderOK()) {
            updateResponse(order,orderResponse);
        }
        return responseAsJSON(orderResponse);
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
        String response = JSON.toJSONString(orderResponse, filter,features);
        return response;
    }

}
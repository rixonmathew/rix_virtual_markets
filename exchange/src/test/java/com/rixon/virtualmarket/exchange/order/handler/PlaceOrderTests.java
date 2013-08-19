package com.rixon.virtualmarket.exchange.order.handler;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This file is used for testing the functionality of placing Orders in the exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 12:52 PM
 */
public class PlaceOrderTests {

    @Test
    public void testSimpleOrderPlacement() {
        Order order = mockOrderForValidOrder();
        assertNotNull(order);
        OrderResponse expectedResponse = mockResponseForValidOrder();
        assertNotNull(expectedResponse);
        OrderHandler orderHandler = new OrderHandler();
        OrderResponse orderResponse = orderHandler.placeOrder(order);
        assertThat(orderResponse, is(expectedResponse));
    }

    @Test
    public void testOrderWithoutTransactTimePlacement() {
        Order order = mockOrderForInvalidOrder();
        assertNotNull(order);
        OrderResponse expectedResponse = mockResponseForInvalidOrder();
        assertNotNull(expectedResponse);
        OrderHandler orderHandler = new OrderHandler();
        OrderResponse orderResponse = orderHandler.placeOrder(order);
        assertThat(orderResponse,is(expectedResponse));
    }

    private Order mockOrderForValidOrder() {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"),Order.class);
    }

    private OrderResponse mockResponseForValidOrder() {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder-response.json"), OrderResponse.class);
    }

    private Order mockOrderForInvalidOrder() {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrderWithoutTransactTime.json"), Order.class);
    }

    private OrderResponse mockResponseForInvalidOrder() {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrderWithoutTransactTime-response.json"),
                OrderResponse.class);
    }


}

package com.rixon.virtualmarket.exchange.order.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class is used for testing the scenarios of getting the order objects based on order id.
 * User: rixon
 * Date: 19/8/13
 * Time: 4:20 PM
 */
public class GetOrderTests {

    @Test
    public void testGetOrderForValidOrder() {
        String orderId="10101";
        OrderHandler orderHandler = new OrderHandler();
        Order order = orderHandler.getOrderForId(orderId);
        Order expectedOrder = mockOrderForId(orderId);
        assertThat("Order is not matching",order,is(expectedOrder));
    }

    private Order mockOrderForId(String orderId) {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"), Order.class);
    }
}

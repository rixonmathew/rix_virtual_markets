package com.rixon.virtualmarket.exchange.order;

import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * This file is used for testing the functionality of placing Orders in the exchnage
 * User: rixon
 * Date: 13/8/13
 * Time: 12:52 PM
 */
public class PlaceOrderTests {

    @Test
    public void testSimpleOrderPlacement() {
       String orderString = mockOrderString();
       assertNotNull(orderString);
       OrderHandler orderHandler = new OrderHandler();
       String orderResponse = orderHandler.placeOrder(orderString);
       assertNotNull(orderResponse);
    }

    private String mockOrderString() {
        return TestUtil.readInputFile("newSingleOrder.json");
    }
}

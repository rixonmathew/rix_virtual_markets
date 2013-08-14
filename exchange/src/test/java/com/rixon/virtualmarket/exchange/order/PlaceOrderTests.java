package com.rixon.virtualmarket.exchange.order;

import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This file is used for testing the functionality of placing Orders in the exchnage
 * User: rixon
 * Date: 13/8/13
 * Time: 12:52 PM
 */
public class PlaceOrderTests {

    @Test
    public void testSimpleOrderPlacement() {
        String orderString = mockOrderStringForValidOrder();
        assertNotNull(orderString);
        String expectedResponse = mockResponseStringForValidOrder();
        assertNotNull(expectedResponse);
        OrderHandler orderHandler = new OrderHandler();
        String orderResponse = orderHandler.placeOrder(orderString);
        assertThat(orderResponse, is(expectedResponse));
    }

    @Test
    public void testOrderWithoutTransactTimePlacement() {
        String  orderString = mockOrderStringForInvalidOrder();
        assertNotNull(orderString);
        String expectedResponse = mockResponseStringForInvalidOrder();
        assertNotNull(expectedResponse);
        OrderHandler orderHandler = new OrderHandler();
        String orderResponse = orderHandler.placeOrder(orderString);
        assertThat(orderResponse,is(expectedResponse));
    }

    private String mockOrderStringForValidOrder() {
        return TestUtil.fileContentAsString("newSingleOrder.json");
    }

    private String mockResponseStringForValidOrder() {
        return TestUtil.fileContentAsString("newSingleOrder-response.json");
    }

    private String mockOrderStringForInvalidOrder() {
        return TestUtil.fileContentAsString("newSingleOrderWithoutTransactTime.json");
    }

    private String mockResponseStringForInvalidOrder() {
        return TestUtil.fileContentAsString("newSingleOrderWithoutTransactTime-response.json");
    }


}

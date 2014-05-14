package com.rixon.virtualmarket.exchange.order.handler;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.exchange.order.repository.OrderRepository;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * This file is used for testing the functionality of placing Orders in the exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 12:52 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class PlaceOrderTests {

    private OrderHandler orderHandler;
    @Mock
    private OrderRepository orderRepository;

    @Before
    public void init() {
        orderHandler = new OrderHandler();
        ReflectionTestUtils.setField(orderHandler, "orderRepository", orderRepository);
    }

    @After
    public void tearDown() {
        orderRepository =  null;
        orderHandler = null;
    }


    @Test
    public void testSimpleOrderPlacement() {
        Order order = mockOrderForValidOrder();
        assertNotNull(order);
        OrderResponse expectedResponse = mockResponseForValidOrder();
        assertNotNull(expectedResponse);
        OrderResponse orderResponse = orderHandler.placeOrder(order);
        verify(orderRepository).save(order);
        assertThat(orderResponse, is(expectedResponse));
    }

    @Test
    public void testOrderWithoutTransactTimePlacement() {
        Order order = mockOrderForInvalidOrder();
        assertNotNull(order);
        OrderResponse expectedResponse = mockResponseForInvalidOrder();
        assertNotNull(expectedResponse);
        OrderResponse orderResponse = orderHandler.placeOrder(order);
        verify(orderRepository,never()).save(order);
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

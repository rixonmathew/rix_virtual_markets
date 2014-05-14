package com.rixon.virtualmarket.exchange.order.handler;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.repository.OrderRepository;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * This class is used for testing the scenarios of getting the order objects based on order id.
 * User: rixon
 * Date: 19/8/13
 * Time: 4:20 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class GetOrderTests {

    @Mock
    private OrderRepository orderRepository;
    private OrderHandler orderHandler;

    @Before
    public void init() {
      orderHandler = new OrderHandler();
      ReflectionTestUtils.setField(orderHandler,"orderRepository",orderRepository);
    }

    @After
    public void tearDown() {
      orderRepository =  null;
      orderHandler = null;
    }

    @Test
    public void testGetOrderForValidOrder() {
        String orderId="10101";
        when(orderRepository.findOne(orderId)).thenReturn(mockOrderForId(orderId));
        Order order = orderHandler.getOrderForId(orderId);
        Order expectedOrder = mockOrderForId(orderId);
        assertThat("Order is not matching",order,is(expectedOrder));
    }

    @Test
    public void testGetOrderForInvalidOrder() {
        String orderId = "NA";
        when(orderRepository.findOne(orderId)).thenReturn(null);
        Order order = orderHandler.getOrderForId(orderId);
        assertNull(order);
    }

    private Order mockOrderForId(String orderId) {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"), Order.class);
    }
}

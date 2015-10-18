package com.rixon.virtualmarket.exchange.order.persistence;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.repository.OrderRepository;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * This class will test the persistence related functionality for storing the orders to data store
 * User: rixon
 * Date: 19/8/13
 * Time: 7:20 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersistenceTests {

    @Autowired
    private OrderRepository orderRepository;
    private Order mockOrder;

    @Before
    public void setup() {
        mockOrder = createMockOrder();
        orderRepository.save(mockOrder);
    }


    @Test
    public void testCreateOrder() {
        Order savedOrder = orderRepository.findOne(mockOrder.getOrderID());
        assertThat("Saved order is not as per mockOrder",savedOrder,is(mockOrder));
    }

    @After
    public void cleanUp(){
        orderRepository.delete(mockOrder);
    }

    private Order createMockOrder() {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"), Order.class);
    }

    @Test
    public void testFindByTradeDate() {
        List<Order> orders = orderRepository.findByTradeDate(mockOrder.getTradeDate());
        assertNotNull(orders);
        assertThat("Trade date is not as expected ",orders.get(0).getTradeDate(),is(mockOrder.getTradeDate()));
    }
}

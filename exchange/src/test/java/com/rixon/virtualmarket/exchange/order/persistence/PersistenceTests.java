package com.rixon.virtualmarket.exchange.order.persistence;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.repository.OrderRepository;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

    @Test
    public void testCreateOrder() {
        Order mockOrder = createMockOrder();
        orderRepository.save(mockOrder);
        Order savedOrder = orderRepository.findOne(mockOrder.getOrderID());
        assertThat("Saved order is not as per mockOrder",savedOrder,is(mockOrder));
        orderRepository.delete(mockOrder);
    }

    private Order createMockOrder() {
        return JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"), Order.class);
    }
}

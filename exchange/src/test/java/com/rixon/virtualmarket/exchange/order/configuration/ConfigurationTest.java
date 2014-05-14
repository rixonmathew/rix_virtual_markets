package com.rixon.virtualmarket.exchange.order.configuration;

import com.rixon.virtualmarket.exchange.order.controller.OrderController;
import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * This class is used for validating the context configuration
 * User: rixon
 * Date: 21/8/13
 * Time: 11:26 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class ConfigurationTest {

    @Autowired
    private OrderHandler orderHandler;

    @Autowired
    private OrderController orderController;

    @Test
    public void testBeans() {
        assertNotNull(orderHandler);
        assertNotNull(orderController);
    }
}
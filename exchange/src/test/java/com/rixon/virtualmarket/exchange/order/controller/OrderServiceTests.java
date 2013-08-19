package com.rixon.virtualmarket.exchange.order.controller;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Ignore;
import org.springframework.web.client.RestTemplate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class is used for testing the RESTFul Services exposed by exchange. The tests should be commented when
 * being run via maven. This can be used after deploying the tests to Tomcat to see if the order is correct or not
 *
 *  User: rixon
 * Date: 14/8/13
 * Time: 2:37 PM
 */
public class OrderServiceTests {

    @Test
    @Ignore
    public void testRestfulServiceForValidOrder() {
        String orderURL = "http://localhost:8080/exchange/order";
        Order mockOrder = JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"),Order.class);
        //place order and validate response
        OrderResponse expectedOrderResponse = JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder-response.json"),OrderResponse.class);
        OrderResponse actualOrderResponse = new RestTemplate().postForObject(orderURL,mockOrder,OrderResponse.class);
        //assert Response
        assertThat("OrderResponse is not matching",expectedOrderResponse,is(actualOrderResponse));
    }

    @Test
    @Ignore
    public void testGetOrderById() {
        String orderURL = "http://localhost:8080/exchange/order";
        OrderResponse actualOrderResponse = new RestTemplate().getForObject(orderURL,OrderResponse.class);
        System.out.println("actualOrderResponse = " + actualOrderResponse);
    }

}

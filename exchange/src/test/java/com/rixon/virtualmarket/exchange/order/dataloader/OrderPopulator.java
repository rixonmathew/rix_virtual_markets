package com.rixon.virtualmarket.exchange.order.dataloader;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.util.TestUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible to create specified number of Mock orders in the database.
 * User: rixon
 * Date: 21/8/13
 * Time: 10:34 AM
 */
public class OrderPopulator {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:mongoConfiguration.xml");
        MongoTemplate mongoTemplate = applicationContext.getBean("mongoTemplate",MongoTemplate.class);
        Assert.notNull(mongoTemplate);
        //long ordersRequired = 1000;
        List<Order> orders =  loadRandomlyGeneratedOrders();//simulateOrders(ordersRequired);
        long time = System.currentTimeMillis();
        for (Order order:orders) {
            mongoTemplate.save(order); //TODO Could not use insertAll as orders generated contained duplicateID's. Introduce flag in ramodage to prevent this from happening
        }
        long timeTaken = System.currentTimeMillis()-time;
        System.out.println("Time taken (ms) "+timeTaken);
        List<Order> allOrders = mongoTemplate.findAll(Order.class);
        System.out.println("Size of orders "+allOrders.size());
    }

    private static List<Order> simulateOrders(long ordersRequired) {
        List<Order> orders = new ArrayList<Order>();
        for (int i = 0;i<ordersRequired;i++){
            Order order = createMockOrder();
            order.setOrderID(order.getOrderID()+"--"+i);
            orders.add(order);
        }
        return orders;
    }

    private static Order createMockOrder() {
        Order order = JSON.parseObject(TestUtil.fileContentAsString("newSingleOrder.json"), Order.class);
        return order;
    }

    private static List<Order> loadRandomlyGeneratedOrders() {
        String jsonString = TestUtil.fileContentAsString("rix_exchange_orders-part-0");
        return JSON.parseArray(jsonString,Order.class);
    }
}

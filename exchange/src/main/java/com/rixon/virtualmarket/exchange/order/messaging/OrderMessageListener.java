package com.rixon.virtualmarket.exchange.order.messaging;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.exchange.order.handler.OrderHandler;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class listens to the messages from the queue for the Orders placed
 * User: rixon
 * Date: 21/8/13
 * Time: 1:24 PM
 */
public class OrderMessageListener implements MessageListener {

    @Autowired
    private OrderHandler orderHandler;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    @Autowired
    private AmqpTemplate orderResponseTemplate;

    @Override
    public void onMessage(final Message message) {

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                String messageBody = new String(message.getBody());
                Order order = JSON.parseObject(messageBody,Order.class);
                OrderResponse orderResponse = orderHandler.placeOrder(order);
                orderResponseTemplate.convertAndSend("response.1",JSON.toJSON(orderResponse));
            }
        });
    }
}

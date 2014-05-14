package com.rixon.virtualmarket.exchange.order.messaging;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is used for testing the functionality where orders can be placed over message queues.
 * User: rixon
 * Date: 21/8/13
 * Time: 12:18 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:rabbit/rabbit-sender-context.xml")
public class MessageBasedOrderingTest {

    @Autowired
    private AmqpTemplate orderTemplate;
    private Set<String> ordersPlaced;

    @Before
    public void init() {
        ordersPlaced = new HashSet<String>();
    }

    @Test
    @Ignore
    public void testSimpleOrderOverMessage() {
        long startTime = System.currentTimeMillis();
        sendMultipleOrdersOverMessages();
        long timeTaken = System.currentTimeMillis()-startTime;
        System.out.println("timeTaken (order placement) = " + timeTaken);
        startTime = System.currentTimeMillis();
        System.out.println("Size of order queue before:"+ordersPlaced.size());
        validateResponses();
        System.out.println("Size of order queue after:"+ordersPlaced.size());
        timeTaken = System.currentTimeMillis()-startTime;
        System.out.println("timeTaken (order validation) = " + timeTaken);
    }

    private void sendMultipleOrdersOverMessages() {
        List<String> orders = JSON.parseArray(TestUtil.fileContentAsString("orders_100k"),String.class);
        int i=1;
        for (String order:orders) {
            //orderTemplate.convertAndSend("order.1",order);
            Order order1 = JSON.parseObject(order,Order.class);
            ordersPlaced.add(order1.getOrderID());
            orderTemplate.convertAndSend("order."+i,order);
            i++;
        }
    }

    private void validateResponses() {
        Object message=null;
        int messageProcessed=0;
        do {
            message = orderTemplate.receiveAndConvert("order_response_queue");
            if (message!=null) {
                messageProcessed++;
                OrderResponse response = JSON.parseObject(message.toString(),OrderResponse.class);
                ordersPlaced.remove(response.getOrderID());
            }
        } while(message!=null);
        System.out.println("Messages processed "+messageProcessed);
    }

    private void sendMessageUsingThreads(final String orderMessage) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running form thread " + Thread.currentThread().getId());
                    for (int i = 0; i < 100000; i++)
                        orderTemplate.convertAndSend("order." + i, orderMessage);
                }
            });
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){}
    }

    private void sendMessagesSerially(String orderMessage) {
        long maxMessages = 100;
        for (int i=0;i<maxMessages;i++)
           orderTemplate.convertAndSend("order."+i,orderMessage);
    }
}

/**
 * Ten thread with 10000 messages each : 15886(ms)
 * 1 thread with 100000  7591 (ms)
 * 1 thread with 1000000 71 secs
 * Ten threads with 100000 158 secs
 * //TODO why is serial performance better than parallel threads in publishing messages
 */

/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RabbitMQClientTest {

	@Autowired private AmqpAdmin admin;
	@Autowired private AmqpTemplate template;

	@Test public void simpleProducerConsumerTest() {
		try {
			String sent = "Catch the rabbit! " + new Date();
			admin.declareQueue( new Queue("test.queue") );

			// write message
			template.convertAndSend( sent );
			// read message
			String received = (String)template.receiveAndConvert();

			System.out.println( "Msg: " + received );
			Assert.assertEquals( sent, received );

		} catch (AmqpException e) {
			Assert.fail( "Test failed: " + e.getLocalizedMessage() );
		}
	}
}

*/
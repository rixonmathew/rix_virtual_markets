package com.rixon.virtualmarket.broker;

import com.rixon.virtualmarket.broker.controller.OrderController;
import com.rixon.virtualmarket.broker.models.OrderResponse;
import com.rixon.virtualmarket.order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BrokerApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port:8877","broker.log.name:broker1"})
public class BrokerApplicationTest {

    @Autowired
    private OrderController orderController;
    private final static Logger LOGGER = LoggerFactory.getLogger(BrokerApplicationTest.class);
    @Value("${local.server.port}")
    int port;

    @Test
    public void testGetOperation(){
        LOGGER.info("Testing Get operations from testGetOperation");
        assertNotNull(orderController);
        RestTemplate rest = new TestRestTemplate();
        String url = "http://localhost:"+port+"/rix_broker";
        ResponseEntity<String> responseEntity = rest.getForEntity(url, String.class);
        assertEquals("HTTP Response status is not as expected", HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Body is not as expected", "I am a prime broker", responseEntity.getBody());
    }

    @Test
    public void testPostOperation() {
        LOGGER.info("Testing post operations from testPostOperation");
        RestTemplate placeOrderTemplate = new TestRestTemplate();
        String url = "http://localhost:"+port+"/rix_broker/order";
        ResponseEntity<OrderResponse> orderResponseResponseEntity = placeOrderTemplate.postForEntity(url, new Order(), OrderResponse.class);
        assertEquals("HTTP Response status is not as expected", HttpStatus.OK,orderResponseResponseEntity.getStatusCode());
    }
}

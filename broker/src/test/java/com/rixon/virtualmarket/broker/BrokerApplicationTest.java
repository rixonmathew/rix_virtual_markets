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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrokerApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties = {"eureka.client.enabled:false","spring.cloud.config.enabled=false","secure_property_file=classpath:/secure-properties.yml"})
public class BrokerApplicationTest {

    @Autowired
    private OrderController orderController;
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final static Logger LOGGER = LoggerFactory.getLogger(BrokerApplicationTest.class);

    @Test
    public void testGetOperation(){
        LOGGER.info("Testing Get operations from testGetOperation");
        assertNotNull(orderController);
        String url = "/rvm_broker";
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url, String.class);
        assertEquals("HTTP Response status is not as expected", HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Body is not as expected", "I am a prime broker", responseEntity.getBody());
    }

    @Test
    public void testPostOperation() {
        LOGGER.info("Testing post operations from testPostOperation");
        String url = "/rvm_broker/order";
        ResponseEntity<OrderResponse> orderResponseResponseEntity = testRestTemplate.postForEntity(url, new Order(), OrderResponse.class);
        assertEquals("HTTP Response status is not as expected", HttpStatus.OK,orderResponseResponseEntity.getStatusCode());
    }
}

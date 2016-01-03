package com.rixon.virtualmarket.dataprovider;

import com.rixon.virtualmarket.order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataProviderApp.class)
@WebIntegrationTest({"server.port:0", "eureka.client.enabled:false"})
public class TestDataProviderApp {

  @Value("${local.server.port}")
  private int port;

  @Test
  public void testGetRandomOrder() {
    RestTemplate randomOrder = new TestRestTemplate();
    String orderURL = "http://localhost:" + port + "/rvm_dataprovider/order";
    final ResponseEntity<Order> orderResponseEntity = randomOrder.getForEntity(orderURL, Order.class);
    assertNotNull(orderResponseEntity);
    assertEquals("Http status code is not as expected", HttpStatus.OK, orderResponseEntity.getStatusCode());
    Order order = orderResponseEntity.getBody();
    System.out.println("order = " + order);
  }
}

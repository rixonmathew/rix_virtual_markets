package com.rixon.virtualmarket.dataprovider;

import com.rixon.virtualmarket.order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DataProviderApp.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties = {"eureka.client.enabled:false"})
public class TestDataProviderApp {

  @Value("${local.server.port}")
  private int port;

  @Test
  public void testGetRandomOrder() {
    TestRestTemplate randomOrder = new TestRestTemplate();
    String orderURL = "http://localhost:" + port + "/rvm_dataprovider/order";
    final ResponseEntity<Order> orderResponseEntity = randomOrder.getForEntity(orderURL, Order.class);
    assertNotNull(orderResponseEntity);
    assertEquals("Http status code is not as expected", HttpStatus.OK, orderResponseEntity.getStatusCode());
    Order order = orderResponseEntity.getBody();
    System.out.println("order = " + order);
  }
}

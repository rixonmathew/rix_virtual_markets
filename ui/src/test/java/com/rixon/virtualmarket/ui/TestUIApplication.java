package com.rixon.virtualmarket.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
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
@SpringApplicationConfiguration(classes = UIApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8879")
public class TestUIApplication {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void testUIEndpoint() {
        RestTemplate uiEndPoint = new TestRestTemplate();
        String uiURL = "http://localhost:"+port+"/rvmui";
        ResponseEntity<String> uiResponse = uiEndPoint.getForEntity(uiURL,String.class);
        assertNotNull(uiResponse);
        assertEquals("Http status code is not as expected", HttpStatus.OK, uiResponse.getStatusCode());
        System.out.println("uiResponse = " + uiResponse.getBody());

    }
}

package com.rixon.virtualmarket.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = UIApplication.class)
public class TestUIApplication {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testUIEndpoint() {
        String uiURL = "/rvmui";
        ResponseEntity<String> uiResponse = testRestTemplate.getForEntity(uiURL,String.class);
        assertNotNull(uiResponse);
        assertEquals("Http status code is not as expected", HttpStatus.OK, uiResponse.getStatusCode());
        System.out.println("uiResponse = " + uiResponse.getBody());
    }
}
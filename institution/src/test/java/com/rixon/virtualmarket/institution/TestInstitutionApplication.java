package com.rixon.virtualmarket.institution;

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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = InstitutionApplication.class,properties = {"eureka.client.enabled:false","spring.cloud.config.enabled:false"})
public class TestInstitutionApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestInstitutionApplication.class);
    @Value("${local.server.port}")
    private int port;
    @Value("${institution.name}")
    private String institutionName;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetOperation(){
        LOGGER.info("Testing Get operations from testGetOperation");
        String url = "/rvm_institution1";
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url, String.class);
        assertEquals("HTTP Response status is not as expected", HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Body is not as expected", "I am an institution "+institutionName, responseEntity.getBody());
    }


}

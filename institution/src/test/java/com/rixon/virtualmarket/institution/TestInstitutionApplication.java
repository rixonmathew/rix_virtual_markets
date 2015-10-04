package com.rixon.virtualmarket.institution;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InstitutionApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8877")
public class TestInstitutionApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestInstitutionApplication.class);
    @Value("${local.server.port}")
    private int port;
    @Value("${institution.name}")
    private String institutionName;

    @Test
    public void testGetOperation(){
        LOGGER.info("Testing Get operations from testGetOperation");
        RestTemplate rest = new TestRestTemplate();
        String url = "http://localhost:"+port+"/rvm_institution1";
        ResponseEntity<String> responseEntity = rest.getForEntity(url, String.class);
        assertEquals("HTTP Response status is not as expected", HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals("Body is not as expected", "I am an institution "+institutionName, responseEntity.getBody());
    }


}

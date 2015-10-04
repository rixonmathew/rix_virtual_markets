package com.rixon.virtualmarket.institution.service;

import com.rixon.virtualmarket.institution.models.Sentiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarketSentimentProvider {

    private String sentimentProviderEndpoint;
    private RestTemplate restTemplate;

    @Autowired
    public MarketSentimentProvider(@Value("${market.sentiment.endpoint}") String sentimentProviderEndpoint) {
        this.sentimentProviderEndpoint = sentimentProviderEndpoint;
    }

    public Sentiment getSentiment() {
        if (restTemplate==null) {
            restTemplate = new RestTemplate();
        }
        ResponseEntity<String> response =  restTemplate.getForEntity(sentimentProviderEndpoint, String.class);
        return Sentiment.valueOf(response.getBody());
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}

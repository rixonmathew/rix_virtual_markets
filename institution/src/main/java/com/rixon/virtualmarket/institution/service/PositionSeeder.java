package com.rixon.virtualmarket.institution.service;

import com.rixon.virtualmarket.dataprovider.provider.PositionProvider;
import com.rixon.virtualmarket.institution.models.InstitutionPositions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PositionSeeder {

    @Autowired
    private InstitutionPositions institutionPositions;
    @Autowired
    private PositionProvider positionProvider;

    @Value("${broker.seed.positions:false}")
    private boolean seedPositions;

    private final static Logger LOGGER = LoggerFactory.getLogger(PositionSeeder.class);

    @PostConstruct
    public void createPositions() {
        if (seedPositions) {
            positionProvider.createPositionsFor(null,1000);
        } else {
          LOGGER.warn("No positions being seeded for broker");
        }
    }
}

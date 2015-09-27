package com.rixon.virtualmarket.dataprovider.provider;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class OrderQuantityProvider {
    private Random random = new Random();

    public BigDecimal getQuantity() {
        return BigDecimal.valueOf(random.nextInt(1_000_000));
    }
}

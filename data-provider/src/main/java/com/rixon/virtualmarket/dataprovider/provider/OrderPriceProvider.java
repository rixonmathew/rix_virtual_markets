package com.rixon.virtualmarket.dataprovider.provider;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class OrderPriceProvider {
    private Random random = new Random();

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(random.nextInt(100));
    }
}

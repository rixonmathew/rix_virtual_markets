package com.rixon.virtualmarket.dataprovider.provider;

import java.math.BigDecimal;
import java.util.Random;

public class OrderPriceProvider {
    private Random random = new Random();

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(random.nextInt(100));
    }
}

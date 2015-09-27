package com.rixon.virtualmarket.dataprovider.provider;

import java.math.BigDecimal;
import java.util.Random;

public class OrderQuantityProvider {
    private Random random = new Random();

    public BigDecimal getQuantity() {
        return BigDecimal.valueOf(random.nextInt(1_000_000));
    }
}

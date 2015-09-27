package com.rixon.virtualmarket.dataprovider.provider;

import java.math.BigDecimal;

public class PriceGenerationContext {

    private int probabilityForPositiveIncrease;
    private BigDecimal maxPriceChangeFactor;

    public int getProbabilityForPositiveIncrease() {
        return probabilityForPositiveIncrease;
    }

    public void setProbabilityForPositiveIncrease(int probabilityForPositiveIncrease) {
        this.probabilityForPositiveIncrease = probabilityForPositiveIncrease;
    }

    public BigDecimal getMaxPriceChangeFactor() {
        return maxPriceChangeFactor;
    }

    public void setMaxPriceChangeFactor(BigDecimal maxPriceChangeFactor) {
        this.maxPriceChangeFactor = maxPriceChangeFactor;
    }
}

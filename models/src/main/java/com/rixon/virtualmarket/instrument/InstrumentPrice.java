package com.rixon.virtualmarket.instrument;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InstrumentPrice {

    private BigDecimal currentPrice;
    private LocalDateTime dateTime;

    public InstrumentPrice() {
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "InstrumentPrice{" +
                "currentPrice=" + currentPrice +
                ", dateTime=" + dateTime +
                '}';
    }
}

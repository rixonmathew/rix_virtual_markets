package com.rixon.virtualmarket.position;

import com.rixon.virtualmarket.instrument.FinancialInstrument;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PositionTransaction {
    private FinancialInstrument financialInstrument;
    private BigDecimal quantity;
    private BigDecimal price;
    private LocalDateTime timestamp;

    public PositionTransaction(FinancialInstrument financialInstrument, BigDecimal quantity, BigDecimal price, LocalDateTime timestamp) {
        this.financialInstrument = financialInstrument;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }

    public FinancialInstrument getFinancialInstrument() {
        return financialInstrument;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

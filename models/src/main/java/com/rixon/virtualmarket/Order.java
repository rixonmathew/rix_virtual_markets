package com.rixon.virtualmarket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Order {

    FinancialInstrument getFinancialInstrument();
    BigDecimal getQuantity();
    BigDecimal getPrice();
    OrderType getOrderType();
    LocalDateTime getOrderDateTime();
}

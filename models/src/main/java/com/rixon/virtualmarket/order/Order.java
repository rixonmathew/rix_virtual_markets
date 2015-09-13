package com.rixon.virtualmarket.order;

import com.rixon.virtualmarket.instrument.FinancialInstrument;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private FinancialInstrument financialInstrument;
    private BigDecimal quantity;
    private BigDecimal price;
    private OrderType orderType;
    private LocalDateTime dateTime;

    public FinancialInstrument getFinancialInstrument() {
        return financialInstrument;
    }

    public void setFinancialInstrument(FinancialInstrument financialInstrument) {
        this.financialInstrument = financialInstrument;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "financialInstrument=" + financialInstrument +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderType=" + orderType +
                ", dateTime=" + dateTime +
                '}';
    }
}

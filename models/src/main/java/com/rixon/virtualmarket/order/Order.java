package com.rixon.virtualmarket.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.rixon.virtualmarket.instrument.FinancialInstrument;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order implements Serializable{

    private static final long serialVersionUID = 42L;

    private String id;
    private FinancialInstrument financialInstrument;
    private BigDecimal quantity;
    private BigDecimal price;
    private OrderType orderType;
    private LocalDateTime dateTime;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", financialInstrument=" + financialInstrument +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderType=" + orderType +
                ", dateTime=" + dateTime +
                '}';
    }
}

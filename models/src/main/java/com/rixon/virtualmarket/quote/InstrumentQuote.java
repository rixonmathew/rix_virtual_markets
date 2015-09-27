package com.rixon.virtualmarket.quote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InstrumentQuote implements Serializable{

    private final static long serialVersionUID=42l;

    private LocalDateTime timeStamp;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal bidQuantity;
    private BigDecimal askQuantity;
    private String currency;
    private BigDecimal tickSize;

    public InstrumentQuote() {
    }

    public InstrumentQuote(LocalDateTime timeStamp, BigDecimal bid, BigDecimal ask, BigDecimal bidQuantity, BigDecimal askQuantity, String currency, BigDecimal tickSize) {
        this.timeStamp = timeStamp;
        this.bid = bid;
        this.ask = ask;
        this.bidQuantity = bidQuantity;
        this.askQuantity = askQuantity;
        this.currency = currency;
        this.tickSize = tickSize;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getBidQuantity() {
        return bidQuantity;
    }

    public BigDecimal getAskQuantity() {
        return askQuantity;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public void setBidQuantity(BigDecimal bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public void setAskQuantity(BigDecimal askQuantity) {
        this.askQuantity = askQuantity;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }

    @Override
    public String toString() {
        return "InstrumentQuote{" +
                "timeStamp=" + timeStamp +
                ", bid=" + bid +
                ", ask=" + ask +
                ", bidQuantity=" + bidQuantity +
                ", askQuantity=" + askQuantity +
                ", currency='" + currency + '\'' +
                ", tickSize=" + tickSize +
                '}';
    }
}

package com.rixon.virtualmarket.quote;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InstrumentQuoteBuilder {
    private LocalDateTime timeStamp;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal bidQuantity;
    private BigDecimal askQuantity;
    private String currency;
    private BigDecimal tickSize;

    public InstrumentQuoteBuilder setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public InstrumentQuoteBuilder setBid(BigDecimal bid) {
        this.bid = bid;
        return this;
    }

    public InstrumentQuoteBuilder setAsk(BigDecimal ask) {
        this.ask = ask;
        return this;
    }

    public InstrumentQuoteBuilder setBidQuantity(BigDecimal bidQuantity) {
        this.bidQuantity = bidQuantity;
        return this;
    }

    public InstrumentQuoteBuilder setAskQuantity(BigDecimal askQuantity) {
        this.askQuantity = askQuantity;
        return this;
    }

    public InstrumentQuoteBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public InstrumentQuoteBuilder setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
        return this;
    }

    public InstrumentQuote createInstrumentQuote() {
        return new InstrumentQuote(timeStamp, bid, ask, bidQuantity, askQuantity, currency, tickSize);
    }
}
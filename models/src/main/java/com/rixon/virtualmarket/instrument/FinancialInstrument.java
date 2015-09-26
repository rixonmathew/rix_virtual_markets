package com.rixon.virtualmarket.instrument;

import com.rixon.virtualmarket.quote.InstrumentQuote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class FinancialInstrument implements Serializable{

    private final static long serialVersionUID=42l;

    private String name;
    private String description;
    private InstrumentType instrumentType;
    private InstrumentQuote instrumentQuote;
    private InstrumentMetrics instrumentMetrics;
    private Map<String,InstrumentIdentifier> identifiers;
    private BigDecimal tickSize;
    private InstrumentQuote issuingQuote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public InstrumentQuote getInstrumentQuote() {
        return instrumentQuote;
    }

    public void setInstrumentQuote(InstrumentQuote instrumentQuote) {
        this.instrumentQuote = instrumentQuote;
    }

    public InstrumentMetrics getInstrumentMetrics() {
        return instrumentMetrics;
    }

    public void setInstrumentMetrics(InstrumentMetrics instrumentMetrics) {
        this.instrumentMetrics = instrumentMetrics;
    }

    private InstrumentIdentifier getIdentifier(String type) {
        return identifiers.get(type);
    }

    public void setIdentifiers(Map<String, InstrumentIdentifier> identifiers) {
        this.identifiers = identifiers;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }

    public InstrumentQuote getIssuingQuote() {
        return issuingQuote;
    }

    public void setIssuingQuote(InstrumentQuote issuingQuote) {
        this.issuingQuote = issuingQuote;
    }

    @Override
    public String toString() {
        return "FinancialInstrument{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", instrumentType=" + instrumentType +
                ", instrumentQuote=" + instrumentQuote +
                ", instrumentMetrics=" + instrumentMetrics +
                ", identifiers=" + identifiers +
                ", tickSize=" + tickSize +
                ", issuingQuote=" + issuingQuote +
                '}';
    }
}

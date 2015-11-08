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
    private String issuingCurrency;
    private String primaryIndetifierType;

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

    public InstrumentIdentifier getIdentifier(String type) {
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

    public void setIssuingCurrency(String issuingCurrency) {
        this.issuingCurrency = issuingCurrency;
    }

    public String getIssuingCurrency() {
        return issuingCurrency;
    }

    public InstrumentIdentifier getPrimaryIdentifier() {
        return identifiers.get(primaryIndetifierType);
    }

    public String getPrimaryIndetifierType() {
        return primaryIndetifierType;
    }

    public void setPrimaryIndetifierType(String primaryIndetifierType) {
        this.primaryIndetifierType = primaryIndetifierType;
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
                ", issuingCurrency='" + issuingCurrency + '\'' +
                '}';
    }
}

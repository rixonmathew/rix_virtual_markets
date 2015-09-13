package com.rixon.virtualmarket.instrument;

import java.util.Map;

public class FinancialInstrument {

    private String name;
    private String description;
    private InstrumentType instrumentType;
    private InstrumentPrice instrumentPrice;
    private InstrumentMetrics instrumentMetrics;
    private Map<String,InstrumentIdentifier> identifiers;

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

    public InstrumentPrice getInstrumentPrice() {
        return instrumentPrice;
    }

    public void setInstrumentPrice(InstrumentPrice instrumentPrice) {
        this.instrumentPrice = instrumentPrice;
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

    @Override
    public String toString() {
        return "FinancialInstrument{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", instrumentType=" + instrumentType +
                ", instrumentPrice=" + instrumentPrice +
                ", instrumentMetrics=" + instrumentMetrics +
                ", identifiers=" + identifiers +
                '}';
    }
}

package com.rixon.virtualmarket.dataprovider.mapper;

import com.rixon.virtualmarket.dataprovider.models.NasdaqCompany;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.instrument.InstrumentIdentifier;
import com.rixon.virtualmarket.instrument.InstrumentType;

import java.util.HashMap;
import java.util.Map;

public class NasdaqCompanyToFIMapper {
    public FinancialInstrument map(NasdaqCompany nasdaqCompany) {
        FinancialInstrument financialInstrument = new FinancialInstrument();
        financialInstrument.setName(nasdaqCompany.getName());
        financialInstrument.setDescription(nasdaqCompany.getSector()+":"+nasdaqCompany.getIndustry());
        financialInstrument.setInstrumentType(new InstrumentType("Common Stocks","Common Stocks"));
        Map<String,InstrumentIdentifier> identifier = new HashMap<>();
        identifier.put("NASDAQ",new InstrumentIdentifier("NASDAQ","NASDAQ",nasdaqCompany.getSymbol()));
        financialInstrument.setIdentifiers(identifier);
        return financialInstrument;
    }
}

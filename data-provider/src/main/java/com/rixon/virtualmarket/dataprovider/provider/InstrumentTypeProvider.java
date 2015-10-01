package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.InstrumentType;

import java.util.*;

public class InstrumentTypeProvider {

    private static Map<String,InstrumentType> instrumentTypeCache;

    private static void loadInstrumentTypeCache() {
        List<String> instrumentTypes= Arrays.asList("Common Stocks", "Preferred Stocks", "Government Bonds", "Corporate Bonds", "Stock Derivatives", "Bond Derivatives");
        instrumentTypeCache = new HashMap<>();
        instrumentTypes.stream().forEach(s->instrumentTypeCache.put(s,new InstrumentType(s,s)));
    }

    public InstrumentType getInstrumentType(String type) {
        if (instrumentTypeCache==null) {
            loadInstrumentTypeCache();
        }
        return instrumentTypeCache.get(type);
    }

    public List<InstrumentType> getAllInstrumentTypes() {
        if (instrumentTypeCache==null) {
            loadInstrumentTypeCache();
        }
        return Collections.unmodifiableList(new ArrayList<>(instrumentTypeCache.values()));
    }

}

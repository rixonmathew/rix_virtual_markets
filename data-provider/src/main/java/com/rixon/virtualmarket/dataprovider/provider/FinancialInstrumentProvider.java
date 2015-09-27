package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.instrument.InstrumentIdentifier;
import com.rixon.virtualmarket.instrument.InstrumentMetrics;
import com.rixon.virtualmarket.instrument.InstrumentType;
import com.rixon.virtualmarket.quote.InstrumentQuote;
import com.rixon.virtualmarket.quote.InstrumentQuoteBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toMap;

@Component
public class FinancialInstrumentProvider {

    private final static long MAX_INSTRUMENTS_IN_CACHE=100;
    private static final double TICK_SIZE = 0.01;
    private static final int MAX_ID_LIMIT = 1_000_000;
    private static Map<String,FinancialInstrument> financialInstrumentCache ;
    private static Map<String,InstrumentType> instrumentTypeCache;
    private static List<InstrumentType> instrumentTypeList;

    public FinancialInstrument getRandomInstrument() {
        if (financialInstrumentCache==null){
            loadCache();
        }
        return financialInstrumentCache.values().stream().parallel().unordered().filter(FinancialInstrumentProvider::rollDice).findFirst().get();
    }

    private static boolean rollDice(FinancialInstrument financialInstrument) {
        Random random = new Random();
        return random.nextInt(3)==1;
    }


    private static void loadCache() {
        loadInstrumentTypeCache();
        financialInstrumentCache = new HashMap<>();
        LongStream.range(0,MAX_INSTRUMENTS_IN_CACHE).forEach(counter->{
            FinancialInstrument financialInstrument = createFinancialInstrument(counter);
            financialInstrumentCache.put(financialInstrument.getIdentifier("ISIN").getValue(),financialInstrument);
        });

    }

    private static void loadInstrumentTypeCache() {
        List<String> instrumentTypes= Arrays.asList("Common Stocks","Preferred Stocks","Government Bonds","Corporate Bonds","Stock Derivatives","Bond Derivatives");
        instrumentTypeCache = new HashMap<>();
        instrumentTypes.stream().forEach(s->instrumentTypeCache.put(s,new InstrumentType(s,s)));
        instrumentTypeList = new ArrayList<>();
        instrumentTypeList.addAll(instrumentTypeCache.values());
    }

    private static FinancialInstrument createFinancialInstrument(long counter) {
        FinancialInstrument financialInstrument = new FinancialInstrument();
        Random random = new Random();
        int randomId = (int) (random.nextInt(MAX_ID_LIMIT)+counter);
        financialInstrument.setDescription("Description for"+randomId);
        financialInstrument.setName("Name for "+randomId);
        financialInstrument.setIdentifiers(createRandomIdentifier(randomId));
        financialInstrument.setInstrumentMetrics(createRandomMetrics());
        financialInstrument.setInstrumentType(getRandomInstrumentType());
        financialInstrument.setTickSize(new BigDecimal(String.valueOf(TICK_SIZE)));
        financialInstrument.setIssuingCurrency("USD");
        financialInstrument.setIssuingQuote(getRandomQuote(financialInstrument));
        financialInstrument.setInstrumentQuote(getRandomQuote(financialInstrument));
        return financialInstrument;
    }

    private static Map<String, InstrumentIdentifier> createRandomIdentifier(int randomId) {
        List<String> identifierTypes = Arrays.asList("CUSIP","ISIN","SEDOL","RIC","CUSTOM");
        return identifierTypes.stream()
                .map(id->new InstrumentIdentifier(id,id,id+":"+randomId))
                .collect(toMap(InstrumentIdentifier::getType,instrumentTypeIdentifier->instrumentTypeIdentifier));
    }

    private static InstrumentMetrics createRandomMetrics() {
        Map<String,String> metrics = new HashMap<>();
        metrics.put("key 1","value 1");
        metrics.put("key 2","value 3");
        metrics.put("key 3","value 3");
        return new InstrumentMetrics(metrics);
    }

    private static InstrumentType getRandomInstrumentType() {
        Random random = new Random();
        return instrumentTypeList.get(random.nextInt(instrumentTypeList.size()));
    }

    private static InstrumentQuote getRandomQuote(FinancialInstrument financialInstrument) {
        InstrumentQuoteBuilder instrumentQuoteBuilder = new InstrumentQuoteBuilder();
        Random random = new Random(200);
        instrumentQuoteBuilder.setTickSize(financialInstrument.getTickSize());
        BigDecimal bid = BigDecimal.valueOf(random.nextInt()).setScale(2, RoundingMode.HALF_DOWN);
        instrumentQuoteBuilder.setBid(bid);
        instrumentQuoteBuilder.setAsk(bid.add(financialInstrument.getTickSize().multiply(BigDecimal.valueOf(5))));
        instrumentQuoteBuilder.setBidQuantity(BigDecimal.TEN);
        instrumentQuoteBuilder.setAskQuantity(BigDecimal.TEN);
        instrumentQuoteBuilder.setCurrency(financialInstrument.getIssuingCurrency());
        instrumentQuoteBuilder.setTimeStamp(LocalDateTime.now());
        return instrumentQuoteBuilder.createInstrumentQuote();
    }

}

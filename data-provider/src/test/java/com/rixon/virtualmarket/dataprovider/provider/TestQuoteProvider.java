package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.quote.InstrumentQuote;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class TestQuoteProvider {

    private QuoteProvider quoteProvider;
    @Mock private FinancialInstrument financialInstrument;
    @Mock private InstrumentQuote currentQuote;
    @Mock private PriceGenerationContext priceGenerationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        quoteProvider = new QuoteProvider();
        mockInstrument();
        mockCurrentQuote();
        mockContext();
    }

    private void mockInstrument() {
        when(financialInstrument.getTickSize()).thenReturn(new BigDecimal("0.01"));
        when(financialInstrument.getIssuingCurrency()).thenReturn("USD");
        when(financialInstrument.getIssuingQuote()).thenReturn(currentQuote);
    }

    private void mockCurrentQuote() {
        when(currentQuote.getBid()).thenReturn(new BigDecimal("17.78"));
        when(currentQuote.getAsk()).thenReturn(new BigDecimal("17.82"));
    }

    private void mockContext() {
        when(priceGenerationContext.getMaxPriceChangeFactor()).thenReturn(BigDecimal.TEN);
        when(priceGenerationContext.getProbabilityForPositiveIncrease()).thenReturn(60);
    }

    @Test
    public void testQuoteStream() {
        final InstrumentQuote initialQuote = quoteProvider.getQuote(financialInstrument,currentQuote,priceGenerationContext);
        Stream.iterate(initialQuote,instrumentQuote -> quoteProvider.getQuote(financialInstrument,instrumentQuote,priceGenerationContext))
              .limit(1000)
              .forEach(System.out::println);
    }
}

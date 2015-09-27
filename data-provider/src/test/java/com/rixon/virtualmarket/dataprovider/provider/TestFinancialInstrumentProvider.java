package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;

public class TestFinancialInstrumentProvider {

    private FinancialInstrumentProvider financialInstrumentProvider;

    @Before
    public void setup() {
       financialInstrumentProvider = new FinancialInstrumentProvider();
    }

    @Test
    public void testGetRandomInstrument() {
//        FinancialInstrument financialInstrument = financialInstrumentProvider.getRandomInstrument();
//        assertNotNull(financialInstrument);
//        System.out.println("financialInstrument = " + financialInstrument);
        Stream.iterate(null,s->financialInstrumentProvider.getRandomInstrument())
                .limit(100)
                .forEach(System.out::println);
    }

}

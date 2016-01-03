package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
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
    Stream.iterate(null, s -> financialInstrumentProvider.getRandomInstrument())
        .limit(100)
        .forEach(System.out::println);
  }

  @Test
  public void testGetMultipleRandomInstruments() {
    long expectedSize = 5000L;
    List<FinancialInstrument> financialInstruments = financialInstrumentProvider.getMultipleRandomInstruments(expectedSize);
    assertNotNull(financialInstruments);
    assertEquals("Size is not as expected ", expectedSize, financialInstruments.size());
    //financialInstruments.stream().forEach(financialInstrument -> System.out.println(financialInstrument.getPrimaryIdentifier().getValue()));
  }
}

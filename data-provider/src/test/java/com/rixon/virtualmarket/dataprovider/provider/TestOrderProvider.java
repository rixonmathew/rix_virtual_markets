package com.rixon.virtualmarket.dataprovider.provider;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

public class TestOrderProvider {

    private OrderProvider orderProvider;
    private FinancialInstrumentProvider financialInstrumentProvider;
    private OrderPriceProvider orderPriceProvider;
    private OrderQuantityProvider orderQuantityProvider;
    private OrderTypeProvider orderTypeProvider;

    @Before
    public void setup() {
        financialInstrumentProvider = new FinancialInstrumentProvider();
        orderPriceProvider = new OrderPriceProvider();
        orderQuantityProvider = new OrderQuantityProvider();
        orderTypeProvider = new OrderTypeProvider();
        orderProvider = new OrderProvider(financialInstrumentProvider,orderTypeProvider,orderPriceProvider,orderQuantityProvider);
    }

    @Test
    public void testGetOrder() {
        Stream.iterate(null,o->orderProvider.getRandomOrder())
               .limit(100)
               .forEach(System.out::println);
    }
}

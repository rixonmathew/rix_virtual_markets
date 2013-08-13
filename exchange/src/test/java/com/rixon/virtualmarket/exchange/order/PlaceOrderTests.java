package com.rixon.virtualmarket.exchange.order;

import com.rixon.virtualmakret.exchange.factory.ExchangeClientFactory;
import com.rixon.virtualmarket.exchange.client.ExchangeClient;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * This file is used for testing the functionality of placing Orders in the exchnage
 * User: rixon
 * Date: 13/8/13
 * Time: 12:52 PM
 */
public class PlaceOrderTests {

    @Test
    public void testSimpleOrderPlacement() {
       String orderString = mockOrderString();
       //TODO this should be a simple HTTP client based tests.
       ExchangeClient exchangeClient = ExchangeClientFactory.createExchangeClient();
       String orderResponse = exchangeClient.placeOrder(orderString);
       assertNotNull(orderResponse);
    }

    private String mockOrderString() {
        return null;  //TODO provide implementation
    }
}

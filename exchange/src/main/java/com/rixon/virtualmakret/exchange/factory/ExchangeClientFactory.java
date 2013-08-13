package com.rixon.virtualmakret.exchange.factory;

import com.rixon.virtualmarket.exchange.client.ExchangeClient;
import com.rixon.virtualmarket.exchange.client.SimpleExchangeClient;

/**
 * This class represents the factory for creating the ExchangeClients
 * User: rixon
 * Date: 13/8/13
 * Time: 1:01 PM
 */
public class ExchangeClientFactory {
    public static ExchangeClient createExchangeClient() {
        return new SimpleExchangeClient();
    }
}

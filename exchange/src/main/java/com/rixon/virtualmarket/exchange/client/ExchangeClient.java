package com.rixon.virtualmarket.exchange.client;

/**
 * This interface represents the client for placing orders in an exchange
 * User: rixon
 * Date: 13/8/13
 * Time: 1:00 PM
 */
public interface ExchangeClient {
    public String placeOrder(String orderString);
}

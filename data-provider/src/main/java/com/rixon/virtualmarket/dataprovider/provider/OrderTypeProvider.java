package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.order.OrderType;

import java.util.Random;

public class OrderTypeProvider {

    private OrderType buy = new OrderType("BUY","Buy");
    private OrderType sell = new OrderType("SELL","Sell");

    public OrderType getBuyOrderType(){
        return buy;
    }

    public OrderType getSellOrderType() {
        return sell;
    }

    public OrderType getRandomOrderType() {
        Random random = new Random();
        if (random.nextInt(2)==1)
            return getBuyOrderType();
        return getSellOrderType();
    }
}

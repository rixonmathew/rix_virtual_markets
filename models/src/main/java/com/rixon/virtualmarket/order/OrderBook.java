package com.rixon.virtualmarket.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBook {

    private List<Order> buyOrders;
    private List<Order> sellOrders;
    private Map<Order,Order> matchedOrders;
    private Map<Order,OrderStatus> orderStatuses;

    public OrderBook() {
        buyOrders = new ArrayList<>();
        sellOrders = new ArrayList<>();
        orderStatuses = new HashMap<>();
    }

    public void addBuyOrder(Order buyOrder) {
        buyOrders.add(buyOrder);
        tryMatching(buyOrder);
        updateStatus(buyOrder);
    }

    private void tryMatching(Order order) {
    }

    private void updateStatus(Order order) {
    }

    public void addSellOrder(Order sellOrder) {
        sellOrders.add(sellOrder);
        tryMatching(sellOrder);
        updateStatus(sellOrder);
    }

}

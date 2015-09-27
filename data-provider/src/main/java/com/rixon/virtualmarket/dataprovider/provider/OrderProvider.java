package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.order.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderProvider {

    private FinancialInstrumentProvider financialInstrumentProvider;
    private OrderTypeProvider orderTypeProvider;
    private OrderPriceProvider orderPriceProvider;
    private OrderQuantityProvider orderQuantityProvider;

    public OrderProvider(FinancialInstrumentProvider financialInstrumentProvider, OrderTypeProvider orderTypeProvider, OrderPriceProvider orderPriceProvider, OrderQuantityProvider orderQuantityProvider) {
        this.financialInstrumentProvider = financialInstrumentProvider;
        this.orderTypeProvider = orderTypeProvider;
        this.orderPriceProvider = orderPriceProvider;
        this.orderQuantityProvider = orderQuantityProvider;
    }

    public Order getRandomOrder() {
        Order order = new Order();
        order.setFinancialInstrument(financialInstrumentProvider.getRandomInstrument());
        order.setDateTime(LocalDateTime.now());
        order.setOrderType(orderTypeProvider.getRandomOrderType());
        order.setPrice(orderPriceProvider.getPrice());
        order.setQuantity(orderQuantityProvider.getQuantity());
        return order;
    }
}

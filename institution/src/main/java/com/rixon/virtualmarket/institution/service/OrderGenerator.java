package com.rixon.virtualmarket.institution.service;

import com.rixon.virtualmarket.dataprovider.provider.OrderProvider;
import com.rixon.virtualmarket.dataprovider.provider.OrderTypeProvider;
import com.rixon.virtualmarket.institution.models.InstitutionPositions;
import com.rixon.virtualmarket.institution.models.Sentiment;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Component
public class OrderGenerator {

    private final MarketSentimentProvider marketSentimentProvider;
    private InstitutionPositions institutionPositions;
    private OrderProvider orderProvider;
    private OrderTypeProvider orderTypeProvider;
    private BrokerService brokerService;
    private volatile boolean processOrders = true;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> scheduledFuture;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderGenerator.class);

    @Autowired
    public OrderGenerator(MarketSentimentProvider marketSentimentProvider, BrokerService brokerService
                          ,OrderProvider orderProvider,OrderTypeProvider orderTypeProvider) {
        this.marketSentimentProvider = marketSentimentProvider;
        this.brokerService = brokerService;
        this.orderProvider = orderProvider;
        this.orderTypeProvider = orderTypeProvider;
    }

    @PostConstruct
    public void placeOrders() {
        startOrderGeneration();
    }

    private void startOrderGeneration() {
        Runnable runnable = (() -> {
            LOGGER.info("Placing order");
            Order order = createOrder();
            if (order != null)
                brokerService.placeOrder(order);
        });
        scheduledFuture = executorService.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

    }

    private Order createOrder( ) {
        Sentiment sentiment = marketSentimentProvider.getSentiment();
        Order order = null;
        switch (sentiment){
            case LONG:
                LOGGER.info("Creating Buy Order");
                order = orderProvider.getOrder(getRandomInstrument(), orderTypeProvider.getBuyOrderType());
                break;
            case SHORT:
                LOGGER.info("Creating Sell Order");
                order = orderProvider.getOrder(getRandomInstrument(), orderTypeProvider.getSellOrderType());
                break;
        }
        return order;
    }

    private FinancialInstrument getRandomInstrument() {
        return institutionPositions.getPositions().stream().unordered().findAny().get().getFinancialInstrument();
    }

    public void stopOrders() {
        LOGGER.info("Stopping order generation process");
        this.scheduledFuture.cancel(true);
    }

    public InstitutionPositions getInstitutionPositions() {
        return institutionPositions;
    }

    public void setInstitutionPositions(InstitutionPositions institutionPositions) {
        this.institutionPositions = institutionPositions;
    }
}

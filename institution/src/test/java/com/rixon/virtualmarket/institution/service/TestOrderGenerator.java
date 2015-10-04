package com.rixon.virtualmarket.institution.service;

import com.rixon.virtualmarket.dataprovider.provider.OrderProvider;
import com.rixon.virtualmarket.dataprovider.provider.OrderTypeProvider;
import com.rixon.virtualmarket.institution.models.InstitutionPositions;
import com.rixon.virtualmarket.institution.models.Sentiment;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.order.Order;
import com.rixon.virtualmarket.order.OrderType;
import com.rixon.virtualmarket.position.Account;
import com.rixon.virtualmarket.position.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TestOrderGenerator {

    private OrderGenerator orderGenerator;
    @Mock private MarketSentimentProvider marketSentimentProvider;
    @Mock private OrderProvider orderProvider;
    private OrderTypeProvider orderTypeProvider;
    @Mock private BrokerService brokerService;
    @Mock private Order order;
    @Mock private FinancialInstrument financialInstrument;
    @Mock private Account account;
    @Mock private InstitutionPositions institutionPositions;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockSentimentProvider();
        mockOrderTypeProvider();
        mockOrder();
        mockOrderProvider();
        mockBrokerService();
        orderGenerator = new OrderGenerator(marketSentimentProvider,brokerService,orderProvider,orderTypeProvider);
        mockFinancialInstrument();
        mockAccount();
        mockInstitutionPositions();
        orderGenerator.setInstitutionPositions(institutionPositions);

    }

    private void mockSentimentProvider() {
        when(marketSentimentProvider.getSentiment()).thenReturn(Sentiment.LONG);
    }

    private void mockOrderTypeProvider() {
        orderTypeProvider = new OrderTypeProvider();
    }


    private void mockOrder() {
        when(order.getOrderType()).thenReturn(orderTypeProvider.getBuyOrderType());
    }

    private void mockOrderProvider() {
        when(orderProvider.getOrder(any(),any())).thenReturn(order);
    }

    private void mockBrokerService() {

    }

    private void mockFinancialInstrument() {
        when(financialInstrument.getDescription()).thenReturn("test");
    }

    private void mockAccount() {
        when(account.getBalance()).thenReturn(BigDecimal.TEN);

    }

    private void mockInstitutionPositions() {
        Position position = new Position(financialInstrument, BigDecimal.TEN,new ArrayList<>(),account);
        when(institutionPositions.getPositions()).thenReturn(Arrays.asList(position));
        institutionPositions = new InstitutionPositions(Arrays.asList(position));
    }


    @Test
    public void testBuyOrderGeneration() {
        orderGenerator.placeOrders();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderGenerator.stopOrders();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void beepForAnHour() throws InterruptedException {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        final Runnable beeper = () -> System.out.println("beep");
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 1, 1, TimeUnit.SECONDS);
        scheduler.schedule(() -> beeperHandle.cancel(true), 60 * 60, TimeUnit.SECONDS);

        Thread.sleep(60_000);
    }


}

package com.rixon.virtualmarket.dataprovider.controller;

import com.rixon.virtualmarket.dataprovider.provider.FinancialInstrumentProvider;
import com.rixon.virtualmarket.dataprovider.provider.OrderProvider;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;

@RestController
@RequestMapping("${dataprovider.endpoint}")
public class DataProviderController {

    @Autowired
    private OrderProvider orderProvider;
    @Autowired
    private FinancialInstrumentProvider financialInstrumentProvider;

    @RequestMapping(
            value = "${dataprovider.order}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Order getRandomOrder() {
        return orderProvider.getRandomOrder();
    }

    @RequestMapping(
            value = "${dataprovider.instrument}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody FinancialInstrument getRandomInstrument() {
        return financialInstrumentProvider.getRandomInstrument();
    }
}

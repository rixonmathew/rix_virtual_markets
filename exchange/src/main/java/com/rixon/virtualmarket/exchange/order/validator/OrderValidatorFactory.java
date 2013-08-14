package com.rixon.virtualmarket.exchange.order.validator;

import com.rixon.virtualmarket.exchange.order.domain.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the factory that provides the various validators.
 * User: rixon
 * Date: 14/8/13
 * Time: 10:39 AM
 */
public class OrderValidatorFactory {

    private final static Map<String,OrderValidator> validatorCache = new HashMap<String, OrderValidator>();
    private static final String BASIC = "BASIC";

    private static void loadCache() {
        OrderValidator basicOrderValidator = new BasicOrderValidator();
        validatorCache.put(BASIC,basicOrderValidator);
        //TODO load more entries into the cache;
    }

    static{
        loadCache();
    }

    public static OrderValidator validatorForOrder(Order order) {
        String key = createKey(order);
        if (validatorCache.containsKey(key)) {
            return validatorCache.get(key);
        } else {
            return validatorCache.get(BASIC);
        }
    }

    private static String createKey(Order order) {
        StringBuilder keyBuilder = new StringBuilder();
        if (order.getSide()!=null){
            keyBuilder.append(order.getSide().toString()).append(":");
        }
        if (order.getOrderType()!=null){
          keyBuilder.append(order.getOrderType().toString());
        }
        return keyBuilder.toString();
    }
}

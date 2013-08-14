package com.rixon.virtualmarket.exchange.order.validator;

import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;

/**
 * This interface represents the validator for Orders
 * User: rixon
 * Date: 14/8/13
 * Time: 10:05 AM
 */
public interface OrderValidator {

    /**
     * This method is used for validating an Order. The validator can differ based on the order attributes.
     * @param order the order to be validated
     * @param orderResponse the response is updated with the results of validation.
     */
    public void validate(Order order,OrderResponse orderResponse);
}

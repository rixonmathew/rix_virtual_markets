package com.rixon.virtualmarket.exchange.order.validator;

import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the basic validator that checks for mandatory field as per
 * the FIX specifications. http://fixwiki.org/fixwiki/NewOrderSingle/FIX.4.4
 *
 * User: rixon
 * Date: 14/8/13
 * Time: 10:48 AM
 */
public class BasicOrderValidator implements OrderValidator {

    @Override
    public void validate(Order order,OrderResponse orderResponse) {
        List<String> errorMessages = new ArrayList<String>();
        boolean isValid=performValidations(order,errorMessages);
        updateResponse(orderResponse, errorMessages, isValid);
    }

    private boolean performValidations(Order order, List<String> errorMessages) {
        boolean isValid = true;

        checkOrderID(order, errorMessages);
        checkInstrument(order, errorMessages);
        checkSide(order, errorMessages);
        checkTransactionTime(order, errorMessages);
        checkOrderQuantity(order, errorMessages);
        checkOrderType(order, errorMessages);

        if (!errorMessages.isEmpty()){
            isValid=false;
        }
        return isValid;
    }

    private void checkOrderID(Order order, List<String> errorMessages) {
        if(order.getOrderID()==null||order.getOrderID().isEmpty()){
            errorMessages.add("OrderID cannot be blank");
        }
    }

    private void checkInstrument(Order order, List<String> errorMessages) {
        if(order.getInstrument()==null||order.getInstrument().isEmpty()) {
            errorMessages.add("Instrument cannot be blank");
        }
    }

    private void checkSide(Order order, List<String> errorMessages) {
        if (order.getSide()==null){
            errorMessages.add("Side cannot be blank");
        }
    }

    private void checkTransactionTime(Order order, List<String> errorMessages) {
        if (order.getTransactTime()==null){
            errorMessages.add("TransactionTime cannot be blank");
        }
    }

    private void checkOrderQuantity(Order order, List<String> errorMessages) {
        if (order.getOrderQuantity()==null||order.getOrderQuantity().isEmpty()){
            errorMessages.add("OrderQuantity cannot be blank");
        }
    }

    private void checkOrderType(Order order, List<String> errorMessages) {
        if (order.getOrderType()==null){
            errorMessages.add("OrderType cannot be blank");
        }
    }

    private void updateResponse(OrderResponse orderResponse, List<String> errorMessages, boolean valid) {
        if(valid)
            orderResponse.setStatus("OK");
        else{
            orderResponse.setStatus("NOK");
            orderResponse.setErrorMessages(errorMessages);
        }
    }
}

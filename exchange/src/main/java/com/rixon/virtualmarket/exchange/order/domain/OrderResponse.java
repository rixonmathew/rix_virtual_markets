package com.rixon.virtualmarket.exchange.order.domain;

import java.util.List;

/**
 * //TODO : Add File information
 * User: rixon
 * Date: 13/8/13
 * Time: 5:35 PM
 */
public class OrderResponse {

    private String status;
    private String orderID;
    private List<String> errorMessages;

    public OrderResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public boolean isOrderOK() {
        return status.equals("OK");
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}

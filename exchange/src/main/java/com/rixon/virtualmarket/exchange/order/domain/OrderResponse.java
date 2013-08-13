package com.rixon.virtualmarket.exchange.order.domain;

/**
 * //TODO : Add File information
 * User: rixon
 * Date: 13/8/13
 * Time: 5:35 PM
 */
public class OrderResponse {

    private String status;
    private String orderID;

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
}

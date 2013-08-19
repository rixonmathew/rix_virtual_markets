package com.rixon.virtualmarket.exchange.order.domain;

import java.util.List;

/**
 * This file represents the response to be sent after Order has been placed
 *
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

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }


    @Override
    public String toString() {
        return "OrderResponse{" +
                "status='" + status + '\'' +
                ", orderID='" + orderID + '\'' +
                ", errorMessages=" + errorMessages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderResponse that = (OrderResponse) o;

        if (errorMessages != null ? !errorMessages.equals(that.errorMessages) : that.errorMessages != null)
            return false;
        if (orderID != null ? !orderID.equals(that.orderID) : that.orderID != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (orderID != null ? orderID.hashCode() : 0);
        result = 31 * result + (errorMessages != null ? errorMessages.hashCode() : 0);
        return result;
    }
}

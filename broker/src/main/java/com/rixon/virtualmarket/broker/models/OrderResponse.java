package com.rixon.virtualmarket.broker.models;

import java.time.LocalDateTime;

public class OrderResponse {

    private String status;
    private LocalDateTime dateTime;

    public OrderResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "status='" + status + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}

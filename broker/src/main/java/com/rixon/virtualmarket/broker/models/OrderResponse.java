package com.rixon.virtualmarket.broker.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
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

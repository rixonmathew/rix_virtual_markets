package com.rixon.virtualmarket.order;

import java.io.Serializable;

public class OrderType implements Serializable{
    private final static long serialVersionUID=42l;

    private String type;
    private String description;

    public OrderType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "OrderType{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.rixon.virtualmarket.order;

public class OrderType {
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

package com.rixon.virtualmarket.legalentity;

import java.io.Serializable;

public class Identifier implements Serializable{
    private final static long serialVersionUID=42l;

    private String type;
    private String description;
    private String value;

    public Identifier(String type, String description, String value) {
        this.type = type;
        this.description = description;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

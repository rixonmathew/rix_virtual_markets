package com.rixon.virtualmarket.instrument;

import java.io.Serializable;

public class InstrumentType implements Serializable{
    private final static long serialVersionUID=42l;

    private String name;
    private String description;

    public InstrumentType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "InstrumentType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

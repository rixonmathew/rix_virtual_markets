package com.rixon.virtualmarket.legalentity;

import java.io.Serializable;
import java.util.Map;

public class LegalEntity implements Serializable{
    private final static long serialVersionUID=42l;

    private String name;
    private Map<String,Identifier> identifiers;

    public LegalEntity(String name, Map<String, Identifier> identifiers) {
        this.name = name;
        this.identifiers = identifiers;
    }

    public String getName() {
        return name;
    }

    private Identifier getIdentifier(String type) {
        return identifiers.get(type);
    }

    @Override
    public String toString() {
        return "LegalEntity{" +
                "name='" + name + '\'' +
                ", identifiers=" + identifiers +
                '}';
    }
}

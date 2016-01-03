package com.rixon.virtualmarket.account;

import java.math.BigDecimal;

public class Account {
    private String name;
    private String identifier;
    private BigDecimal balance;
    private String currency;

    public Account(String name, String identifier, BigDecimal balance, String currency) {
        this.name = name;
        this.identifier = identifier;
        this.balance = balance;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}

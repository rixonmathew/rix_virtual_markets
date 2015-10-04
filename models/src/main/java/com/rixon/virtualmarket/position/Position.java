package com.rixon.virtualmarket.position;

import com.rixon.virtualmarket.instrument.FinancialInstrument;

import java.math.BigDecimal;
import java.util.List;

public class Position {
    private FinancialInstrument financialInstrument;
    private BigDecimal quantity;
    private List<PositionTransaction> positionsTransactions;
    private Account account;

    public Position(FinancialInstrument financialInstrument, BigDecimal quantity, List<PositionTransaction> positionsTransactions, Account account) {
        this.financialInstrument = financialInstrument;
        this.quantity = quantity;
        this.positionsTransactions = positionsTransactions;
        this.account = account;
    }

    public FinancialInstrument getFinancialInstrument() {
        return financialInstrument;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public List<PositionTransaction> getPositionsTransactions() {
        return positionsTransactions;
    }

    public Account getAccount() {
        return account;
    }

    public void updatePositions(List<PositionTransaction> positionsTransactions) {
        if (positionsTransactions==null||positionsTransactions.isEmpty())
            return;
        positionsTransactions.stream().forEach(positionTransaction -> {
            positionsTransactions.add(positionTransaction);
            quantity.add(positionTransaction.getQuantity());
        });

    }
}

package com.rixon.virtualmarket.bootstrap;

import com.rixon.virtualmarket.bootstrap.models.participant.Participant;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.position.Account;
import com.rixon.virtualmarket.position.Position;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PositionSeeder {

    private List<FinancialInstrument> financialInstruments;

    public PositionSeeder(List<FinancialInstrument> financialInstruments) {
        this.financialInstruments = financialInstruments;
    }

    public void seedPositions(List<Participant> participants) {
        //For each participant create positions based on which participants can trade
        //For every institution create long positions in various assets
        participants.forEach(p->financialInstruments.forEach(f->p.addPosition(createPosition(f))));
    }

    private Position createPosition(FinancialInstrument financialInstrument) {
        return new Position(financialInstrument, new BigDecimal("1_000_000"),new ArrayList<>(),createAccount(financialInstrument));

    }

    private Account createAccount(FinancialInstrument financialInstrument) {
        return new Account("Trading Account["+financialInstrument.getPrimaryIdentifier().getValue()+"]","TRD",BigDecimal.ZERO,financialInstrument.getIssuingCurrency());
    }
}

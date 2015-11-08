package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.position.Position;

public interface Participant {
    String getName();
    ParticipantType getType();
    void startParticipant();
    void stopParticipant();
    String getStatus();
    Position getPositionFor(FinancialInstrument financialInstrument);
    void addPosition(Position position);
}

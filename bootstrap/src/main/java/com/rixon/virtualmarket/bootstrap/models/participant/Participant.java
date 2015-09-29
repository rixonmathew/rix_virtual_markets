package com.rixon.virtualmarket.bootstrap.models.participant;

public interface Participant {
    String getName();
    ParticipantType getType();
    void startParticipant();
    void stopParticipant();
    String getStatus();
}

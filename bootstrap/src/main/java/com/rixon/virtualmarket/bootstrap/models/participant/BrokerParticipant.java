package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.participant.DefaultParticipant;
import com.rixon.virtualmarket.bootstrap.models.participant.ParticipantType;
import com.rixon.virtualmarket.bootstrap.models.config.BrokerConfig;

public class BrokerParticipant extends DefaultParticipant{

    private BrokerConfig brokerConfig;

    public BrokerParticipant(CommandExecutor commandExecutor, BrokerConfig brokerConfig) {
        super(commandExecutor);
        this.brokerConfig = brokerConfig;
        prepareCommands();

    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return brokerConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.BROKER;
    }
}

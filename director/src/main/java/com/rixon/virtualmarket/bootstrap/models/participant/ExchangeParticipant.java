package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.ExchangeConfig;

public class ExchangeParticipant extends DefaultParticipant {

    private ExchangeConfig exchangeConfig;

    public ExchangeParticipant(CommandExecutor commandExecutor, ExchangeConfig exchangeConfig) {
        super(commandExecutor);
        this.exchangeConfig = exchangeConfig;
        prepareCommands();
    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return exchangeConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.EXCHANGE;
    }
}

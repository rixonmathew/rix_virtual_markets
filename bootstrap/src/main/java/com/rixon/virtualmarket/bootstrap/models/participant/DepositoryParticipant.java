package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.DepositoryConfig;

public class DepositoryParticipant extends DefaultParticipant {

    private DepositoryConfig depositoryConfig;

    public DepositoryParticipant(CommandExecutor commandExecutor, DepositoryConfig depositoryConfig) {
        super(commandExecutor);
        this.depositoryConfig =depositoryConfig;
        prepareCommands();
    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return depositoryConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.DEPOSITORY;
    }
}

package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.ClearingHouseConfig;

public class ClearingHouseParticipant extends DefaultParticipant {

    private ClearingHouseConfig clearingHouseConfig;
    public ClearingHouseParticipant(CommandExecutor commandExecutor, ClearingHouseConfig clearingHouseConfig) {
        super(commandExecutor);
        this.clearingHouseConfig = clearingHouseConfig;
        prepareCommands();
    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return clearingHouseConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.CLEARINGHOUSE;
    }
}

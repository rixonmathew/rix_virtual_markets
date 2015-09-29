package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.CustodianConfig;

public class CustodianParticipant extends DefaultParticipant {

    private CustodianConfig custodianConfig;

    public CustodianParticipant(CommandExecutor commandExecutor, CustodianConfig custodianConfig) {
        super(commandExecutor);
        this.custodianConfig = custodianConfig;
        this.prepareCommands();
    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return custodianConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.CUSTODIAN;
    }
}

package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.RegulatorConfig;

public class RegulatorParticipant extends DefaultParticipant {

    private RegulatorConfig regulatorConfig;

    public RegulatorParticipant(CommandExecutor commandExecutor, RegulatorConfig regulatorConfig) {
        super(commandExecutor);
        this.regulatorConfig = regulatorConfig;
        prepareCommands();
    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return regulatorConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.REGULATOR;
    }
}

package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.participant.DefaultParticipant;
import com.rixon.virtualmarket.bootstrap.models.participant.ParticipantType;
import com.rixon.virtualmarket.bootstrap.models.config.InstitutionConfig;

public class InstitutionParticipant extends DefaultParticipant {

    private InstitutionConfig institutionConfig;

    public InstitutionParticipant(CommandExecutor commandExecutor, InstitutionConfig institutionConfig) {
        super(commandExecutor);
        this.institutionConfig = institutionConfig;
        prepareCommands();
    }

    @Override
    protected void prepareCommands() {

    }

    @Override
    public String getName() {
        return institutionConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.INSTITUTION;
    }
}

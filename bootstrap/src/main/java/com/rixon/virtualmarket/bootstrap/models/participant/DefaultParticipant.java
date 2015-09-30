package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;

public abstract class DefaultParticipant implements Participant {

    protected CommandExecutor commandExecutor;
    protected String[] startCommand;
    protected String[] stopCommand;
    protected String[] statusCommand;

    public DefaultParticipant(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    protected abstract void prepareCommands();

    @Override
    public abstract String getName();

    @Override
    public abstract ParticipantType getType();

    @Override
    public void startParticipant() {
        commandExecutor.execute(startCommand);
    }

    @Override
    public void stopParticipant() {
        commandExecutor.execute(stopCommand);
    }

    @Override
    public String getStatus() {
        return commandExecutor.executeWithStatus(stopCommand);
    }
}

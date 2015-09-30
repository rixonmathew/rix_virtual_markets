package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public abstract class DefaultParticipant implements Participant {

    protected CommandExecutor commandExecutor;
    protected String[] startCommand;
    protected String[] stopCommand;
    protected String[] statusCommand;

    public DefaultParticipant(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    protected abstract void prepareCommands();

    protected String convertToPropertyName(String camelCaseName) {
        if (camelCaseName==null||camelCaseName.isEmpty())
            return null;
        return Stream.of(camelCaseName.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")).map(String::toLowerCase).collect(joining("."));
    }

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

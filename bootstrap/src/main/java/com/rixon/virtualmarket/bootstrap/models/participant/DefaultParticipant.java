package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.DefaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public abstract class DefaultParticipant implements Participant {

    protected CommandExecutor commandExecutor;
    protected String[] startCommand;
    protected String[] stopCommand;
    protected String[] statusCommand;
    protected final Logger LOGGER = LoggerFactory.getLogger(DefaultParticipant.class);

    public DefaultParticipant(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    protected abstract void prepareCommands();

    protected String convertToPropertyName(String camelCaseName) {
        if (camelCaseName==null||camelCaseName.isEmpty())
            return null;
        return Stream.of(camelCaseName.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")).map(String::toLowerCase).collect(joining("."));
    }

    protected void writeDefaultProperties(BufferedWriter writer,DefaultConfig defaultConfig) throws IOException {
        writer.write("server.port="+defaultConfig.getServerPort());
        writer.newLine();
        writer.write("server.address="+defaultConfig.getServerAddress());
        writer.newLine();
        writer.write("server.sessionTimeout="+defaultConfig.getServerSessionTimeout());
        writer.newLine();
        writer.write("info.app.name="+defaultConfig.getInfoAppName());
        writer.newLine();
        writer.write("info.app.description="+defaultConfig.getInfoAppDescription());
        writer.newLine();
        writer.write("info.app.version="+defaultConfig.getInfoAppVersion());
        writer.newLine();
        writer.write("pid.location="+defaultConfig.getPidLocation());
        writer.newLine();
        writer.write("pid.filename="+defaultConfig.getPidFileName());
        writer.newLine();
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

    @Override
    public String toString() {
        return "DefaultParticipant{" +
                "statusCommand=" + Arrays.toString(statusCommand) +
                ", stopCommand=" + Arrays.toString(stopCommand) +
                ", startCommand=" + Arrays.toString(startCommand) +
                '}';
    }
}

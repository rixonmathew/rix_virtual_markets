package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.DefaultConfig;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.position.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public abstract class DefaultParticipant implements Participant {

    //TODO move the process execution bit to a separate entity. Participant should be a functional entity
    protected CommandExecutor commandExecutor;
    protected String[] startCommand;
    protected String[] stopCommand;
    protected String[] statusCommand;
    protected final Logger LOGGER = LoggerFactory.getLogger(DefaultParticipant.class);
    protected Map<String,List<Position>> instrumentPositions;

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
    public Position getPositionFor(FinancialInstrument financialInstrument) {
        if (financialInstrument==null) {
            LOGGER.error("Invalid financialInstrument specified with null value");
            return null;
        }
        Position position = null;
        List<Position> positions = instrumentPositions.get(financialInstrument.getPrimaryIdentifier().getValue());
        if (positions==null||positions.isEmpty()) {
            LOGGER.info("No positions found for instrument [{}]",financialInstrument);
        } else{
            position = positions.get(0);
        }
        return position;
    }

    @Override
    public void addPosition(Position position) {
        if (position==null) {
            LOGGER.warn("Null position specified. It has not been added");
            return;
        }
        if (instrumentPositions==null){
            instrumentPositions = new HashMap<>();
            List<Position> positions = new ArrayList<>();
            positions.add(position);
            instrumentPositions.put(position.getFinancialInstrument().getPrimaryIdentifier().getValue(),positions);
            return;
        }
        FinancialInstrument financialInstrument = position.getFinancialInstrument();
        if (financialInstrument==null) {
            LOGGER.error("Invalid position specified [{}] ",position);
            return;
        }
        String primaryIdentifierValue = financialInstrument.getPrimaryIdentifier().getValue();
        List<Position> existingPositions = instrumentPositions.get(primaryIdentifierValue);
        if (existingPositions==null){
            existingPositions = new ArrayList<>();
        }
        existingPositions.add(position);
        instrumentPositions.put(primaryIdentifierValue,existingPositions);
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

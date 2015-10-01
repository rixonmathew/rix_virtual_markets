package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.BrokerConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BrokerParticipant extends DefaultParticipant{

    private BrokerConfig brokerConfig;

    public BrokerParticipant(CommandExecutor commandExecutor, BrokerConfig brokerConfig) {
        super(commandExecutor);
        this.brokerConfig = brokerConfig;
        prepareCommands();

    }

    @Override
    protected void prepareCommands() {
        startCommand = new String[10];
        startCommand[0] = "java";
        startCommand[1] = "-Dspring.config.location="+getConfigFileLocation();
        startCommand[2] = "-Dbroker.log.location="+brokerConfig.getLogFileLocation();
        startCommand[3] = "-Dbroker.name.log="+brokerConfig.getLogFileName();
        startCommand[4] = "-Dbroker.name.err="+brokerConfig.getErrorFileName();
        startCommand[5] = "-jar";
        startCommand[6] = brokerConfig.getJarLocation()+"/"+brokerConfig.getJarName();

        /**
         commandExecutor.execute("java","-Dspring.config.location=/Users/rixonmathew/workspace/github/rix_virtual_markets/configuration/broker/broker1/rvm_broker1.properties"
         ,"-Dbroker.name.log=broker1","-Dbroker.log.location=/tmp/rvm_logs/broker"
         ,"-jar","/Users/rixonmathew/workspace/github/rix_virtual_markets/broker/target/broker-1.0-SNAPSHOT.jar");
         */

    }

    private String getConfigFileLocation() {
        /**
         * Create a config file with the property values at jar file location
         */
        String fileName=null;
        try {
            Path propertyFile = null;
            Path propertyDir = Paths.get(brokerConfig.getJarLocation());
            if (!propertyDir.toFile().exists()) {
                LOGGER.info("Directory [{}] not found. Creating it",propertyDir.toFile().getAbsolutePath());
                Files.createDirectories(propertyDir);
            }
            propertyFile = Paths.get(brokerConfig.getJarLocation() + "/" + brokerConfig.getName() + ".properties");
            if (propertyFile.toFile().exists()) {
                LOGGER.info("Property file found [{}]. deleting it ",propertyFile.toFile().getAbsolutePath());
                propertyFile.toFile().delete();
            } else {
                propertyFile = Files.createFile(propertyFile);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(propertyFile.toFile()));
            bufferedWriter.write("broker.endpoint="+brokerConfig.getBrokerEndpoint());
            bufferedWriter.newLine();
            bufferedWriter.write("broker.order.endpoint="+brokerConfig.getBrokerOrderEndpoint());
            bufferedWriter.newLine();
            writeDefaultProperties(bufferedWriter,brokerConfig);
            bufferedWriter.close();
            fileName = propertyFile.toFile().getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @Override
    public String getName() {
        return brokerConfig.getName();
    }

    @Override
    public ParticipantType getType() {
        return ParticipantType.BROKER;
    }

    @Override
    public String toString() {
        return "BrokerParticipant{" +
                super.toString()+" "+
                "brokerConfig=" + brokerConfig +
                '}';
    }
}

package com.rixon.virtualmarket.bootstrap;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.bootstrap.models.config.MarketConfig;
import com.rixon.virtualmarket.bootstrap.models.participant.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RVMLoader {

    private final static Logger LOGGER = LoggerFactory.getLogger(RVMLoader.class);
    private List<Participant> participants;
    private CommandExecutor commandExecutor;
    private MarketConfig marketConfig;

    public void start(String inputPropertiesFileName) throws IOException {
        LOGGER.info("Starting Virtual markets");
        marketConfig = JSON.parseObject(readInputFile(inputPropertiesFileName), MarketConfig.class);
        LOGGER.info("Got market configuration [{}]", marketConfig);
        if (commandExecutor==null)
            commandExecutor = new CommandExecutor(new ProcessExecutionContext(marketConfig.getLogDirectory(), marketConfig.getLogName(), marketConfig.getErrorFileName()));
        determineParticipants();
        participants.stream().forEach(Participant::startParticipant);
    }

    private String readInputFile(String configurationFileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(configurationFileName));
        StringBuilder stringBuffer = new StringBuilder();
        String line = br.readLine();
        stringBuffer.append(line);
        while (line != null) {
            line = br.readLine();
            if (line != null)
                stringBuffer.append(line);
        }
        br.close();
        return stringBuffer.toString();
    }

    private void determineParticipants() {
        participants = new ArrayList<>();
        createBrokerParticipants();
        createInstitutionParticipants();
        createExchangeParticipants();
        createCustodianParticipants();
        createRegulatorParticipants();
        createDepositoryParticipants();
        createClearingHouseParticipants();
    }

    private void createBrokerParticipants() {
        if (marketConfig.getBrokerConfigs()!=null  && !marketConfig.getBrokerConfigs().isEmpty()) {
            marketConfig.getBrokerConfigs().stream()
                    .forEach(brokerConfig -> participants.add(new BrokerParticipant(commandExecutor,brokerConfig)));
        }
    }

    private void createInstitutionParticipants() {
        if (marketConfig.getInstitutionConfigs()!=null && !marketConfig.getInstitutionConfigs().isEmpty()) {
            marketConfig.getInstitutionConfigs().stream()
                    .forEach(institutionConfig -> participants.add(new InstitutionParticipant(commandExecutor,institutionConfig)));
        }
    }

    private void createExchangeParticipants() {
        if (marketConfig.getExchangeConfigs()!=null && !marketConfig.getExchangeConfigs().isEmpty()){
            marketConfig.getExchangeConfigs().stream()
                    .forEach(exchangeConfig -> participants.add(new ExchangeParticipant(commandExecutor, exchangeConfig)));
        }

    }

    private void createCustodianParticipants() {
        if (marketConfig.getCustodianConfigs()!=null && !marketConfig.getCustodianConfigs().isEmpty()){
            marketConfig.getCustodianConfigs().stream()
                    .forEach(custodianConfig -> participants.add(new CustodianParticipant(commandExecutor, custodianConfig)));
        }
    }

    private void createRegulatorParticipants() {
        if (marketConfig.getRegulatorConfigs()!=null && !marketConfig.getRegulatorConfigs().isEmpty()){
            marketConfig.getRegulatorConfigs().stream()
                    .forEach(regulatorConfig -> participants.add(new RegulatorParticipant(commandExecutor, regulatorConfig)));
        }
    }

    private  void createDepositoryParticipants() {
        if (marketConfig.getDepositoryConfigs()!=null && !marketConfig.getDepositoryConfigs().isEmpty()){
            marketConfig.getDepositoryConfigs().stream()
                    .forEach(depositoryConfig -> participants.add(new DepositoryParticipant(commandExecutor, depositoryConfig)));
        }

    }

    private void createClearingHouseParticipants() {
        if (marketConfig.getClearingHouseConfigs()!=null && !marketConfig.getClearingHouseConfigs().isEmpty()){
            marketConfig.getClearingHouseConfigs().stream()
                    .forEach(clearingHouseConfig -> participants.add(new ClearingHouseParticipant(commandExecutor,clearingHouseConfig)));
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public MarketConfig getMarketConfig() {
        return marketConfig;
    }
}

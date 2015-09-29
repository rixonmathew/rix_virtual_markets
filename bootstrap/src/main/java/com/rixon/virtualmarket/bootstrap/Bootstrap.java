package com.rixon.virtualmarket.bootstrap;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.bootstrap.models.participant.*;
import com.rixon.virtualmarket.bootstrap.models.config.MarketConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bootstrap {

    private final static Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);


    public static void main(String[] args) throws Exception{

        if(args.length!=2) {
            System.err.println("Usage java -jar rvm_bootstrap.jar --file <properties.file>");
            return;
        }
        LOGGER.info("Starting Virtual markets");
        String inputPropertiesFileName = args[1];
        MarketConfig marketConfig = JSON.parseObject(readInputFile(inputPropertiesFileName), MarketConfig.class);
        LOGGER.info("Got market configuration [{}]",marketConfig);
        List<Participant> participants = determineParticipants(marketConfig,new CommandExecutor());
        participants.stream().forEach(Participant::startParticipant);

    }

    private static String readInputFile(String configurationFileName) throws IOException {
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

    private static List<Participant> determineParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor) {
        List<Participant> participants = new ArrayList<>();

        createBrokerParticipants(marketConfig, commandExecutor, participants);
        createInstitutionParticipants(marketConfig, commandExecutor, participants);
        createExchangeParticipants(marketConfig, commandExecutor, participants);
        createCustodianParticipants(marketConfig, commandExecutor, participants);
        createRegulatorParticipants(marketConfig, commandExecutor, participants);
        createDepositoryParticipants(marketConfig, commandExecutor, participants);
        createClearingHouseParticipants(marketConfig, commandExecutor, participants);

        return participants;
    }

    private static void createBrokerParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getBrokerConfigs()!=null  && !marketConfig.getBrokerConfigs().isEmpty()) {
            marketConfig.getBrokerConfigs().stream()
                    .forEach(brokerConfig -> participants.add(new BrokerParticipant(commandExecutor,brokerConfig)));
        }
    }

    private static void createInstitutionParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getInstitutionConfigs()!=null && !marketConfig.getInstitutionConfigs().isEmpty()) {
            marketConfig.getInstitutionConfigs().stream()
                    .forEach(institutionConfig -> participants.add(new InstitutionParticipant(commandExecutor,institutionConfig)));
        }
    }


    private static void createExchangeParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getExchangeConfigs()!=null && !marketConfig.getExchangeConfigs().isEmpty()){
            marketConfig.getExchangeConfigs().stream()
                    .forEach(exchangeConfig -> participants.add(new ExchangeParticipant(commandExecutor, exchangeConfig)));
        }

    }

    private static void createCustodianParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getCustodianConfigs()!=null && !marketConfig.getCustodianConfigs().isEmpty()){
            marketConfig.getCustodianConfigs().stream()
                    .forEach(custodianConfig -> participants.add(new CustodianParticipant(commandExecutor, custodianConfig)));
        }
    }

    private static void createRegulatorParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getRegulatorConfigs()!=null && !marketConfig.getRegulatorConfigs().isEmpty()){
            marketConfig.getRegulatorConfigs().stream()
                    .forEach(regulatorConfig -> participants.add(new RegulatorParticipant(commandExecutor, regulatorConfig)));
        }
    }

    private static void createDepositoryParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getDepositoryConfigs()!=null && !marketConfig.getDepositoryConfigs().isEmpty()){
            marketConfig.getDepositoryConfigs().stream()
                    .forEach(depositoryConfig -> participants.add(new DepositoryParticipant(commandExecutor, depositoryConfig)));
        }

    }

    private static void createClearingHouseParticipants(MarketConfig marketConfig, CommandExecutor commandExecutor, List<Participant> participants) {
        if (marketConfig.getClearingHouseConfigs()!=null && !marketConfig.getClearingHouseConfigs().isEmpty()){
            marketConfig.getClearingHouseConfigs().stream()
                    .forEach(clearingHouseConfig -> participants.add(new ClearingHouseParticipant(commandExecutor,clearingHouseConfig)));
        }
    }

}

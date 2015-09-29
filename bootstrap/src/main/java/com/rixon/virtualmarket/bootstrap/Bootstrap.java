package com.rixon.virtualmarket.bootstrap;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.bootstrap.models.MarketConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
        List<Participant> participants = determineParticipants(marketConfig);
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

    private static List<Participant> determineParticipants(MarketConfig marketConfig) {
        return new ArrayList<>();
    }


    interface Participant {
        String getName();
        ParticpantType getType();
        void startParticipant();
        void stopParticipant();
        String getStatus();
    }

    enum ParticpantType{
        BROKER,
        INSTITUTION,
        EXCHANGE,
        CUSTODIAN,
        REGULATOR,
        DEPOSITORY,
        CLEARINGHOUSE;
    }
}

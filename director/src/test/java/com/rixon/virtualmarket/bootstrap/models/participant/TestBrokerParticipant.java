package com.rixon.virtualmarket.bootstrap.models.participant;

import com.rixon.virtualmarket.bootstrap.CommandExecutor;
import com.rixon.virtualmarket.bootstrap.models.config.BrokerConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class TestBrokerParticipant {

    private BrokerParticipant brokerParticipant;
    @Mock private BrokerConfig brokerConfig;
    @Mock private CommandExecutor commandExecutor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockCommandExecutor();
        mockBrokerConfig();
        brokerParticipant = new BrokerParticipant(commandExecutor,brokerConfig);
    }

    @Test
    public void testCommandPreparation() {
        System.out.println("brokerParticipant = " + brokerParticipant);
    }

    private void mockCommandExecutor() {

    }

    private void mockBrokerConfig() {
        when(brokerConfig.getBrokerEndpoint()).thenReturn("/rvm_broker1");
        when(brokerConfig.getBrokerOrderEndpoint()).thenReturn("/order");
        when(brokerConfig.getLogFileLocation()).thenReturn("/tmp/rvm_logs/broker");
        when(brokerConfig.getLogFileName()).thenReturn("rvm_broker1");
        when(brokerConfig.getErrorFileName()).thenReturn("rvm_broker1.err");
        when(brokerConfig.getJarLocation()).thenReturn("/tmp/rvm");
        when(brokerConfig.getJarName()).thenReturn("broker.jar");
        when(brokerConfig.getName()).thenReturn("broker1");
        when(brokerConfig.getServerPort()).thenReturn(11280);
        when(brokerConfig.getServerAddress()).thenReturn("0.0.0.0");
        when(brokerConfig.getServerSessionTimeout()).thenReturn("0");
        when(brokerConfig.getInfoAppName()).thenReturn("Broker 1");
        when(brokerConfig.getInfoAppDescription()).thenReturn("Description for Broker 1");
        when(brokerConfig.getInfoAppVersion()).thenReturn("1.0.0");
        when(brokerConfig.getPidLocation()).thenReturn("/tmp/rvm/pids");
        when(brokerConfig.getPidFileName()).thenReturn("rvm_broker1.pid");
    }

}

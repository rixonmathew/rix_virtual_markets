package com.rixon.virtualmarket.bootstrap.models;

import java.util.List;

public class MarketConfig {

    private boolean messagingMode;
    private boolean localSetup;
    private String logLevel;
    private List<BrokerConfig> brokerConfigs;

    public boolean isMessagingMode() {
        return messagingMode;
    }

    public void setMessagingMode(boolean messagingMode) {
        this.messagingMode = messagingMode;
    }

    public boolean isLocalSetup() {
        return localSetup;
    }

    public void setLocalSetup(boolean localSetup) {
        this.localSetup = localSetup;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public List<BrokerConfig> getBrokerConfigs() {
        return brokerConfigs;
    }

    public void setBrokerConfigs(List<BrokerConfig> brokerConfigs) {
        this.brokerConfigs = brokerConfigs;
    }

    @Override
    public String toString() {
        return "MarketConfig{" +
                "messagingMode=" + messagingMode +
                ", localSetup=" + localSetup +
                ", logLevel='" + logLevel + '\'' +
                ", brokerConfigs=" + brokerConfigs +
                '}';
    }
}

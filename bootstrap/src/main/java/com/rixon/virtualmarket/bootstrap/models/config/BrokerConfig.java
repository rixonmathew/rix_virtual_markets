package com.rixon.virtualmarket.bootstrap.models.config;

public class BrokerConfig extends DefaultConfig {

    private String brokerEndpoint;
    private String brokerOrderEndpoint;

    public String getBrokerEndpoint() {
        return brokerEndpoint;
    }

    public void setBrokerEndpoint(String brokerEndpoint) {
        this.brokerEndpoint = brokerEndpoint;
    }

    public String getBrokerOrderEndpoint() {
        return brokerOrderEndpoint;
    }

    public void setBrokerOrderEndpoint(String brokerOrderEndpoint) {
        this.brokerOrderEndpoint = brokerOrderEndpoint;
    }

    @Override
    public String toString() {
        return "BrokerConfig{" +
                super.toString()+
                "brokerEndpoint='" + brokerEndpoint + '\'' +
                ",brokerOrderEndpoint='" + brokerOrderEndpoint + '\'' +
                '}';
    }
}

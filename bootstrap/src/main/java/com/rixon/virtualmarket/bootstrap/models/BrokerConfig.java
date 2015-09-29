package com.rixon.virtualmarket.bootstrap.models;

public class BrokerConfig {

    private int port;
    private String name;
    private String brokerEndpoint;
    private String brokerOrderEndpoint;
    private int serverPort;
    private String serverAddress;
    private String serverSessionTimeout;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerSessionTimeout() {
        return serverSessionTimeout;
    }

    public void setServerSessionTimeout(String serverSessionTimeout) {
        this.serverSessionTimeout = serverSessionTimeout;
    }

    @Override
    public String toString() {
        return "BrokerConfig{" +
                "port=" + port +
                ", name='" + name + '\'' +
                ", brokerEndpoint='" + brokerEndpoint + '\'' +
                ", brokerOrderEndpoint='" + brokerOrderEndpoint + '\'' +
                ", serverPort=" + serverPort +
                ", serverAddress='" + serverAddress + '\'' +
                ", serverSessionTimeout='" + serverSessionTimeout + '\'' +
                '}';
    }
}

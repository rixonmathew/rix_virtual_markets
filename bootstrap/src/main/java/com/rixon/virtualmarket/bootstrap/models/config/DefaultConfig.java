package com.rixon.virtualmarket.bootstrap.models.config;

public class DefaultConfig {
    protected String name;
    protected int serverPort;
    protected String serverAddress;
    protected String serverSessionTimeout;
    protected String infoAppName;
    protected String infoAppDescription;
    protected String pidLocation;
    protected String pidFileName;
    protected String jarName;
    protected String jarLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getInfoAppName() {
        return infoAppName;
    }

    public void setInfoAppName(String infoAppName) {
        this.infoAppName = infoAppName;
    }

    public String getInfoAppDescription() {
        return infoAppDescription;
    }

    public void setInfoAppDescription(String infoAppDescription) {
        this.infoAppDescription = infoAppDescription;
    }

    public String getPidLocation() {
        return pidLocation;
    }

    public void setPidLocation(String pidLocation) {
        this.pidLocation = pidLocation;
    }

    public String getPidFileName() {
        return pidFileName;
    }

    public void setPidFileName(String pidFileName) {
        this.pidFileName = pidFileName;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    public String getJarLocation() {
        return jarLocation;
    }

    public void setJarLocation(String jarLocation) {
        this.jarLocation = jarLocation;
    }

    @Override
    public String toString() {
        return "DefaultConfig{" +
                "name='" + name + '\'' +
                ", serverPort=" + serverPort +
                ", serverAddress='" + serverAddress + '\'' +
                ", serverSessionTimeout='" + serverSessionTimeout + '\'' +
                ", infoAppName='" + infoAppName + '\'' +
                ", infoAppDescription='" + infoAppDescription + '\'' +
                ", pidLocation='" + pidLocation + '\'' +
                ", pidFileName='" + pidFileName + '\'' +
                ", jarName='" + jarName + '\'' +
                ", jarLocation='" + jarLocation + '\'' +
                '}';
    }
}

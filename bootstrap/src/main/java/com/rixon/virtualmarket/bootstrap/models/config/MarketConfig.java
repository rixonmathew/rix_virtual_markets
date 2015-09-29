package com.rixon.virtualmarket.bootstrap.models.config;

import java.util.List;

public class MarketConfig {

    private boolean messagingMode;
    private boolean localSetup;
    private String logLevel;
    private List<BrokerConfig> brokerConfigs;
    private List<InstitutionConfig> institutionConfigs;
    private List<ExchangeConfig> exchangeConfigs;
    private List<CustodianConfig> custodianConfigs;
    private List<RegulatorConfig> regulatorConfigs;
    private List<DepositoryConfig> depositoryConfigs;
    private List<ClearingHouseConfig> clearingHouseConfigs;
    private List<UIConfig> uiConfigs;

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

    public List<InstitutionConfig> getInstitutionConfigs() {
        return institutionConfigs;
    }

    public void setInstitutionConfigs(List<InstitutionConfig> institutionConfigs) {
        this.institutionConfigs = institutionConfigs;
    }

    public List<ExchangeConfig> getExchangeConfigs() {
        return exchangeConfigs;
    }

    public void setExchangeConfigs(List<ExchangeConfig> exchangeConfigs) {
        this.exchangeConfigs = exchangeConfigs;
    }

    public List<CustodianConfig> getCustodianConfigs() {
        return custodianConfigs;
    }

    public void setCustodianConfigs(List<CustodianConfig> custodianConfigs) {
        this.custodianConfigs = custodianConfigs;
    }

    public List<RegulatorConfig> getRegulatorConfigs() {
        return regulatorConfigs;
    }

    public void setRegulatorConfigs(List<RegulatorConfig> regulatorConfigs) {
        this.regulatorConfigs = regulatorConfigs;
    }

    public List<DepositoryConfig> getDepositoryConfigs() {
        return depositoryConfigs;
    }

    public void setDepositoryConfigs(List<DepositoryConfig> depositoryConfigs) {
        this.depositoryConfigs = depositoryConfigs;
    }

    public List<ClearingHouseConfig> getClearingHouseConfigs() {
        return clearingHouseConfigs;
    }

    public void setClearingHouseConfigs(List<ClearingHouseConfig> clearingHouseConfigs) {
        this.clearingHouseConfigs = clearingHouseConfigs;
    }

    public List<UIConfig> getUiConfigs() {
        return uiConfigs;
    }

    public void setUiConfigs(List<UIConfig> uiConfigs) {
        this.uiConfigs = uiConfigs;
    }

    @Override
    public String toString() {
        return "MarketConfig{" +
                "messagingMode=" + messagingMode +
                ", localSetup=" + localSetup +
                ", logLevel='" + logLevel + '\'' +
                ", brokerConfigs=" + brokerConfigs +
                ", institutionConfigs=" + institutionConfigs +
                ", exchangeConfigs=" + exchangeConfigs +
                ", custodianConfigs=" + custodianConfigs +
                ", regulatorConfigs=" + regulatorConfigs +
                ", depositoryConfigs=" + depositoryConfigs +
                ", clearingHouseConfigs=" + clearingHouseConfigs +
                ", uiConfigs=" + uiConfigs +
                '}';
    }
}

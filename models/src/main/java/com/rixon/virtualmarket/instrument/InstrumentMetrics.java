package com.rixon.virtualmarket.instrument;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InstrumentMetrics implements Serializable{
    private final static long serialVersionUID=42l;

    private Map<String,String> metrics = new HashMap<>();

    public InstrumentMetrics() {
    }

    public InstrumentMetrics(Map<String, String> metrics) {
        this.metrics = metrics;
    }

    public String getMetricValue(String metric){
        return metrics.get(metric);
    }

    public void setMetrics(Map<String, String> metrics) {
        this.metrics = metrics;
    }

    public Map<String, String> getMetrics() {
        return metrics;
    }

    @Override
    public String toString() {
        return "InstrumentMetrics{" +
                "metrics=" + metrics +
                '}';
    }
}

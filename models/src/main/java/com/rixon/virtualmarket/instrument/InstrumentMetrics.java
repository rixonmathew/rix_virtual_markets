package com.rixon.virtualmarket.instrument;

import java.util.HashMap;
import java.util.Map;

public class InstrumentMetrics {

    private Map<String,String> metrics = new HashMap<>();

    public InstrumentMetrics(Map<String, String> metrics) {
        this.metrics = metrics;
    }

    public String getMetricValue(String metric){
        return metrics.get(metric);
    }

    @Override
    public String toString() {
        return "InstrumentMetrics{" +
                "metrics=" + metrics +
                '}';
    }
}

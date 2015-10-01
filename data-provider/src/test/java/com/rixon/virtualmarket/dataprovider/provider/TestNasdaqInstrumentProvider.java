package com.rixon.virtualmarket.dataprovider.provider;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class TestNasdaqInstrumentProvider {

    private String csvFileName = "nasdaq_comps.csv";
    private NasdaqInstrumentProvider nasdaqInstrumentProvider;

    @Before
    public void setup() {
        nasdaqInstrumentProvider = new NasdaqInstrumentProvider(csvFileName);
    }

    @Test
    public void testLoadInstrumentsFromCsv() {
        try {
            nasdaqInstrumentProvider.loadInstrumentsFromCsv();
        } catch (IOException e) {
            fail("An exception occurred "+e);
        }
    }
}

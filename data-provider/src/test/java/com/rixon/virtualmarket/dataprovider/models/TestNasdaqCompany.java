package com.rixon.virtualmarket.dataprovider.models;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertNotNull;

public class TestNasdaqCompany {

    private String csvRecord;
    private NasdaqCompany nasdaqCompany;

    @Before
    public void setup() {
        csvRecord = "\"TFSC\",\"1347 Capital, Corp.\",\"9.8\",\"$58.29M\",\"2014\",\"Finance\",\"Business Services\",\"http://www.nasdaq.com/symbol/tfsc\",";
    }

    @Test
    public void testModel() {
        nasdaqCompany = new NasdaqCompany(csvRecord);
        assertNotNull(nasdaqCompany);
        System.out.println("nasdaqCompany = " + nasdaqCompany);
    }
}

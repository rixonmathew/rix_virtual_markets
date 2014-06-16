package com.rixon.virtualmarket.util;

import com.rixon.ramodage.factory.RamodageFactory;
import com.rixon.ramodage.main.Ramodage;
import com.rixon.ramodage.model.RandomData;
import com.rixon.ramodage.util.Constants;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * User: rixonmathew
 * Date: 16/06/14
 * Time: 4:28 PM
 */
public class TestRamodage {

    private Ramodage ramodage;


    @Before
    public void setup() {
        ramodage = RamodageFactory.getWithDefaultOptions();
    }

    @Test
    public void testRandomDataGeneration() {
        Properties properties =  createMockProperties();
        RandomData<DailyTrade> randomData = ramodage.generateData(properties);
        assertNotNull(randomData);
        List<DailyTrade> allTrades = randomData.getAllRecords();
        assertNotNull(allTrades);
        int expectedSize=10_000;
        assertThat("Size is not as expected ",allTrades.size(),is(expectedSize));
        for (int i=0;i<100;i++) {
            DailyTrade dailyTrade = randomData.getRandomRecord();
            assertNotNull(dailyTrade);
        }
    }

    private Properties createMockProperties() {
        Properties properties = new Properties();
        properties.setProperty(Constants.SCHEMA_CONTENT,TestUtil.fileContentAsString("daily_trades.json"));
        properties.setProperty(Constants.DESTINATION_TYPE,"IN_MEMORY");
        properties.setProperty(Constants.OBJECT_CLASS_NAME,"com.rixon.virtualmarket.util.DailyTrade");
        properties.setProperty(Constants.NUMBER_OF_SPLITS,"10");
        properties.setProperty(Constants.RECORDS_PER_SPLIT,"1000");
        return properties;

    }

}

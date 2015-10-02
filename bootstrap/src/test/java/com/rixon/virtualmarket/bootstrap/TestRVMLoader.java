package com.rixon.virtualmarket.bootstrap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyVararg;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TestRVMLoader {

    private RVMLoader rvmLoader;
    @Mock
    private CommandExecutor commandExecutor;
    private String marketsJsonFile;
    private int EXPECTED_PARTICIPANT;


    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        ClassPathResource classPathResource = new ClassPathResource("testMarkets.json");
        marketsJsonFile = classPathResource.getFile().getAbsolutePath();
        prepareMockCommandExecutor();
        rvmLoader = new RVMLoader();
        rvmLoader.setCommandExecutor(commandExecutor);
        EXPECTED_PARTICIPANT = 2;
    }

    private void prepareMockCommandExecutor() {

    }

    @Test
    public void testRVMLoader() {
        try {
            rvmLoader.start(marketsJsonFile);
            assertEquals("Length of participants is not as expected",EXPECTED_PARTICIPANT,rvmLoader.getParticipants().size());
            verify(commandExecutor,times(EXPECTED_PARTICIPANT)).execute(anyVararg());
        } catch (IOException e) {
            fail("An exception occurred while testing "+e);
        }
    }
}

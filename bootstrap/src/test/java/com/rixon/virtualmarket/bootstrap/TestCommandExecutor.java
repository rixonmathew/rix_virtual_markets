package com.rixon.virtualmarket.bootstrap;

import org.junit.Before;
import org.junit.Test;

public class TestCommandExecutor {

    private CommandExecutor commandExecutor;

    @Before
    public void setup() {
        commandExecutor = new CommandExecutor();
    }

    @Test
    public void testExecute() {
      //commandExecutor.execute("ls");
      //commandExecutor.execute("java","-jar","/Users/rixonmathew/workspace/github/rix_virtual_markets/bootstrap/target/bootstrap-1.0-SNAPSHOT.jar");
      commandExecutor.execute("java","-version");
    }
}

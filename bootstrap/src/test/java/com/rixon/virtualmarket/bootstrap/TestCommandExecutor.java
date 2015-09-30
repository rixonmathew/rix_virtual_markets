package com.rixon.virtualmarket.bootstrap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class TestCommandExecutor {

    private static final String LOG_DIR = "/tmp/rvm_logs_test";
    private static final String LOG_FILE_NAME = "rvm_processes.log";
    private static final String ERR_FILE_NAME = "rvm_processes.log.err";
    private ProcessExecutionContext processExecutionContext;
    private CommandExecutor commandExecutor;

    @Before
    public void setup() {
        processExecutionContext = new ProcessExecutionContext(LOG_DIR,LOG_FILE_NAME,ERR_FILE_NAME);
        commandExecutor = new CommandExecutor(processExecutionContext);
    }

    @Test
    @Ignore("to be run locally only as the spawned process will not get terminated")
    public void testExecute() {
      //commandExecutor.execute("ls");
      //commandExecutor.execute("java","-jar","/Users/rixonmathew/workspace/github/rix_virtual_markets/bootstrap/target/bootstrap-1.0-SNAPSHOT.jar");
      commandExecutor.execute("java","-Dspring.config.location=/Users/rixonmathew/workspace/github/rix_virtual_markets/configuration/broker/broker1/rvm_broker1.properties"
                               ,"-Dbroker.name.log=broker1","-Dbroker.log.location=/tmp/rvm_logs/broker"
                               ,"-jar","/Users/rixonmathew/workspace/github/rix_virtual_markets/broker/target/broker-1.0-SNAPSHOT.jar");
    }

    @Test
    public void testCamelCaseSplit() {
        String word = "serverPortAndWordBBCGot";
        String propertyName = Stream.of(word.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")).map(s->s.toLowerCase()).collect(joining("."));
        System.out.println("propertyName = " + propertyName);
    }
}

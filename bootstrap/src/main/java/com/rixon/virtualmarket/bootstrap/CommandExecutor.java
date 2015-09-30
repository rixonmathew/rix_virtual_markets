package com.rixon.virtualmarket.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class CommandExecutor {

    private final static Logger LOGGER = LoggerFactory.getLogger(CommandExecutor.class);
    private ProcessExecutionContext processExecutionContext;

    public CommandExecutor(ProcessExecutionContext processExecutionContext) {
        this.processExecutionContext = processExecutionContext;
    }

    public void execute(String ... commandAndArgs) {
        ProcessBuilder pb =
                new ProcessBuilder(commandAndArgs);
        Map<String, String> env = pb.environment();
////        env.put("VAR1", "myValue");
////        env.remove("OTHERVAR");
////        env.put("VAR2", env.get("VAR1") + "suffix");
        File directory = new File(processExecutionContext.getLogDir());
        if (!directory.exists())
            directory.mkdir();
        pb.directory(directory);
        File log = new File(processExecutionContext.getLogFileName());
        File error = new File(processExecutionContext.getErrorFileName());
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        pb.redirectError(ProcessBuilder.Redirect.appendTo(error));
        Process p = null;
        try {
            p = pb.start();
            LOGGER.info("Process started [{}] ",p);
//            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
//            assert pb.redirectOutput().file() == log;
//            assert p.getInputStream().read() == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String executeWithStatus(String ...command) {
        return "to implement"; //TODO
    }

}

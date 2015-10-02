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
        File directory = new File(processExecutionContext.getLogDir());
        if (!directory.exists())
            directory.mkdir();
        pb.directory(directory);
        File log = new File(directory.getPath()+"/"+processExecutionContext.getLogFileName());
        File error = new File(directory.getPath()+"/"+processExecutionContext.getErrorFileName());
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        pb.redirectError(ProcessBuilder.Redirect.appendTo(error));
        Process p;
        try {
            p = pb.start();
            LOGGER.info("Process started [{}] ",p);
        } catch (IOException e) {
            //TODO Better exception handling
            e.printStackTrace();
        }
    }

    public String executeWithStatus(String ...command) {
        return "to implement"; //TODO
    }

}

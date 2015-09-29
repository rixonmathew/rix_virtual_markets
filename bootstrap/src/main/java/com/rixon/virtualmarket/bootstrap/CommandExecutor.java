package com.rixon.virtualmarket.bootstrap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class CommandExecutor {

    public void execute(String ... commandAndArgs) {
        ProcessBuilder pb =
                new ProcessBuilder(commandAndArgs);
        Map<String, String> env = pb.environment();
////        env.put("VAR1", "myValue");
////        env.remove("OTHERVAR");
////        env.put("VAR2", env.get("VAR1") + "suffix");
//        pb.directory(new File("myDir"));
//        File log = new File("log");
//        pb.redirectErrorStream(true);
//        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process p = null;
        pb.inheritIO();
        try {
            p = pb.start();
//            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
//            assert pb.redirectOutput().file() == log;
//            assert p.getInputStream().read() == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String executeWithStatus(String command,String...args) {
        return "to implement"; //TODO
    }

}

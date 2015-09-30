package com.rixon.virtualmarket.bootstrap;

public class ProcessExecutionContext {

    private String logDir;
    private String logFileName;
    private String errorFileName;

    public ProcessExecutionContext(String logDir, String logFileName, String errorFileName) {
        this.logDir = logDir;
        this.logFileName = logFileName;
        this.errorFileName = errorFileName;
    }

    public String getLogDir() {
        return logDir;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public String getErrorFileName() {
        return errorFileName;
    }
}

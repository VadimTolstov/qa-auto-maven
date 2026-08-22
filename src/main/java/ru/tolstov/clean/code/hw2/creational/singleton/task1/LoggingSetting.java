package ru.tolstov.clean.code.hw2.creational.singleton.task1;

public class LoggingSetting {
    private final String loggingLevel;
    private final String pathLogFile;

    public LoggingSetting(String loggingLevel, String pathLogFile) {
        this.loggingLevel = loggingLevel;
        this.pathLogFile = pathLogFile;
    }

    public String getLoggingLevel() {
        return loggingLevel;
    }

    public String getPathLogFile() {
        return pathLogFile;
    }

    @Override
    public String toString() {
        return "LoggingSetting{" +
                "loggingLevel='" + loggingLevel + '\'' +
                ", pathLogFile='" + pathLogFile + '\'' +
                '}';
    }
}

package ru.tolstov.clean.code.hw2.creational.singleton.task2;

import java.util.Objects;

public abstract class Log {
    private final LoggerType loggerType;
    abstract void record(String message);

    public Log(LoggerType loggerType) {
        this.loggerType = loggerType;
    }

    public LoggerType getLoggerType() {
        return loggerType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Log log)) return false;
        return loggerType == log.loggerType;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(loggerType);
    }
}

package ru.tolstov.clean.code.hw2.creational.singleton.task2;

import java.util.EnumMap;
import java.util.Map;

public class Logger {
    private static Logger instance;
    private final Map<LoggerType, Log> loggerMap = new EnumMap<>(LoggerType.class);

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void initializeLogger(Log... logs) {
        for (Log log : logs) {
            if (log != null && !loggerMap.containsKey(log.getLoggerType())) {
                loggerMap.put(log.getLoggerType(), log);
            } else {
                throw new IllegalArgumentException("Logger type already exists");
            }
        }
    }

    public void recordLog(LoggerType loggerType, String message) {
        Log log = loggerMap.get(loggerType);
        log.record(message);
        System.out.println("В логах записано новое сообщение: " + message);
    }
}

package ru.tolstov.clean.code.hw2.creational.singleton.task2;

public class LoggerWarning extends Log {
    public LoggerWarning() {
        super(LoggerType.WARNING);
    }

    @Override
    public void record(String message) {
        System.out.println("Warning: " + message);
    }
}

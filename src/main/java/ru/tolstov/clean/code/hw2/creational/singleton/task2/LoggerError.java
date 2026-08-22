package ru.tolstov.clean.code.hw2.creational.singleton.task2;

import java.util.Objects;

public class LoggerError extends Log {
    public LoggerError() {
        super(LoggerType.ERROR);
    }

    @Override
    public void record(String message) {
        System.out.println("Ошибка при выполнении операций: " + message);
    }
}

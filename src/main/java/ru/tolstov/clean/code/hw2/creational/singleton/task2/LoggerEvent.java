package ru.tolstov.clean.code.hw2.creational.singleton.task2;

public class LoggerEvent extends Log {
    public LoggerEvent() {
        super(LoggerType.EVENT);
    }

    @Override
    public void record(String message) {
        System.out.println("Зафиксировано подключение к базе данных: " + message);
    }
}

package ru.tolstov.clean.code.hw2.creational.singleton.task2;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.initializeLogger(new LoggerWarning(), new LoggerError(), new LoggerEvent());

        logger.recordLog(LoggerType.EVENT, "Событие подключения к системе");
        logger.recordLog(LoggerType.ERROR, "Ошибочное сообщение");
        logger.recordLog(LoggerType.WARNING, "Предупреждение о проблеме");
    }
}

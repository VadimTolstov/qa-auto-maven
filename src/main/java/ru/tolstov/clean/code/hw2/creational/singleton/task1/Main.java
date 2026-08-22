package ru.tolstov.clean.code.hw2.creational.singleton.task1;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        configurationManager.initialize(
                new DatabaseConfig("localhost", "root", "test"),
                new LoggingSetting("WAR", "log.txt"),
                "file.txt"
        );

        ConfigurationManager configurationManager2 = ConfigurationManager.getInstance();

        System.out.println(configurationManager==configurationManager2);
        System.out.println(configurationManager.getDatabaseConfig());
        System.out.println(configurationManager.getLoggingSetting());
        System.out.println(configurationManager.getPathToFile());
    }
}

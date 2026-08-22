package ru.tolstov.clean.code.hw2.creational.singleton.task1;

/**
 * ConfigurationManager был создан с концепцией, что он может быть в одном экземпляре и не изменяемым после инициализации.
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private  String pathToFile;
    private DatabaseConfig databaseConfig;
    private LoggingSetting loggingSetting;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void initialize(DatabaseConfig databaseConfig, LoggingSetting loggingSetting, String pathToFile) {
        if (this.databaseConfig != null && this.loggingSetting != null && this.pathToFile != null) {
            throw new IllegalArgumentException("ConfigurationManager is already initialized");
        }
        this.pathToFile = pathToFile;
        this.databaseConfig = databaseConfig;
        this.loggingSetting = loggingSetting;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public DatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

    public LoggingSetting getLoggingSetting() {
        return loggingSetting;
    }
}

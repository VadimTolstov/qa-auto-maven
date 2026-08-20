package ru.tolstov.clean.code.hw2.creational.fabricmethod.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Класс для регистрации фабрик транспорта
 */
public class TransportFactoryRegistry {
    private static final Map<TransportType, Supplier<TransportFactory>> factories = new HashMap<>();

    public static void register(TransportType transportType, Supplier<TransportFactory> factory) {
        factories.put(transportType, factory);
    }

    public static TransportFactory getFactory(TransportType transportType) {
        Supplier<TransportFactory> factory = factories.get(transportType);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown transport type: " + transportType);
        }
        return factory.get();
    }
}

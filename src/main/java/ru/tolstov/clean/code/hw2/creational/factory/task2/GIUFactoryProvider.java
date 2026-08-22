package ru.tolstov.clean.code.hw2.creational.factory.task2;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GIUFactoryProvider {
    private static final Map<GUIType, Supplier<GUIFactory>> FACTORIES = new EnumMap<>(GUIType.class);

    public static void registerFactory(GUIType type, Supplier<GUIFactory> factory) {
        FACTORIES.put(type, factory);
    }

    public static GUIFactory getFactory(GUIType type) {
        Supplier<GUIFactory> factory = FACTORIES.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown GUI type: " + type);
        }
        return factory.get();
    }
}

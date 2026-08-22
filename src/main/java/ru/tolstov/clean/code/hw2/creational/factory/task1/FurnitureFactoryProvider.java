package ru.tolstov.clean.code.hw2.creational.factory.task1;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class FurnitureFactoryProvider {
    private static final Map<FurnitureStyle, Supplier<FurnitureFactory>> FACTORIES = new EnumMap<>(FurnitureStyle.class);

    public static void registerFactory(FurnitureStyle style, Supplier<FurnitureFactory> factory) {
        FACTORIES.put(style, factory);
    }

    public static FurnitureFactory getFactory(FurnitureStyle style) {
        Supplier<FurnitureFactory> factorySupplier = FACTORIES.get(style);
        if (factorySupplier == null) {
            throw new IllegalArgumentException("Unknown style: " + style);
        }
        return factorySupplier.get();
    }
}

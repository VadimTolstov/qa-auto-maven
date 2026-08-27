package ru.tolstov.clean.code.hw3.task1;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShortenStrategyRegistry {
    private static final Map<StrategyType, Supplier<ShortenerFactory>> STRATEGY_MAP = new EnumMap<>(StrategyType.class);

    public static void registerShorteningStrategy(StrategyType type, Supplier<ShortenerFactory> strategy) {
        STRATEGY_MAP.put(type, strategy);
    }

    public static ShortenerFactory getShorteningStrategyFactory(StrategyType type) {
        Supplier<ShortenerFactory> strategy = STRATEGY_MAP.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("No strategy registered for type " + type);
        }
        return strategy.get();
    }
}

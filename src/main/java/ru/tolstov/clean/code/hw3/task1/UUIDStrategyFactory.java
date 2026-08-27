package ru.tolstov.clean.code.hw3.task1;

public class UUIDStrategyFactory implements ShortenerFactory {
    @Override
    public ShorteningStrategy createShorteningStrategy() {
        return new UUIDStrategy();
    }
}

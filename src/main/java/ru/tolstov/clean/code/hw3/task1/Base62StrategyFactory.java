package ru.tolstov.clean.code.hw3.task1;

public class Base62StrategyFactory implements ShortenerFactory{
    @Override
    public ShorteningStrategy createShorteningStrategy() {
        return new Base62Strategy();
    }
}

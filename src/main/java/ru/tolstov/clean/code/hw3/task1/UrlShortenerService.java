package ru.tolstov.clean.code.hw3.task1;

public class UrlShortenerService {
    private final UrlStorage storageUrl;
    private final ShorteningStrategy strategyUrl;

    public UrlShortenerService(UrlStorage storageUrl, ShortenerFactory shortenerFactory) {
        this.storageUrl = storageUrl;
        this.strategyUrl = shortenerFactory.createShorteningStrategy();
    }

    public String shortenUrl(String longUrl) {
        String shortUrl = strategyUrl.shortenURL(longUrl);
        storageUrl.saveUrl(longUrl, shortUrl);
        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        return storageUrl.getLongUrl(shortUrl);
    }
}

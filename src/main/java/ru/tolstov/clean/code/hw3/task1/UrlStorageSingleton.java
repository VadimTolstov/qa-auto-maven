package ru.tolstov.clean.code.hw3.task1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum UrlStorageSingleton implements UrlStorage {
    INSTANCE;
    private final Map<String, String> longToShortUrl = new ConcurrentHashMap<>();
    private final Map<String, String> shortToLongUrl = new ConcurrentHashMap<>();


    @Override
    public void saveUrl(String longUrl, String shortUrl) {
        longToShortUrl.put(longUrl, shortUrl);
        shortToLongUrl.put(shortUrl, longUrl);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return shortToLongUrl.get(shortUrl);
    }

    @Override
    public String getShortenUrl(String longUrl) {
        return longToShortUrl.get(longUrl);
    }

    @Override
    public Map<String, String> getAllUrls() {
        return new ConcurrentHashMap<>(longToShortUrl);
    }
}

package ru.tolstov.clean.code.hw3.task1;

import java.util.Map;

public interface UrlStorage {

    void saveUrl(String longUrl, String shortUrl);

    String getLongUrl(String shortUrl);

    String getShortenUrl(String longUrl);

    Map<String, String> getAllUrls();
}

package ru.tolstov.clean.code.hw3.task1;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class UUIDStrategy implements ShorteningStrategy {
    @Override
    public String shortenURL(String url) {
        UUID uuid = UUID.nameUUIDFromBytes(url.getBytes(StandardCharsets.UTF_8));
        return uuid.toString();
    }
}

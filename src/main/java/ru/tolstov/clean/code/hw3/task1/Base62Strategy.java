package ru.tolstov.clean.code.hw3.task1;

import io.seruco.encoding.base62.Base62;

import java.nio.charset.StandardCharsets;

public class Base62Strategy implements ShorteningStrategy {
    private final Base62 base62 = Base62.createInstance();

    @Override
    public String shortenURL(String url) {
        byte[] encodedBytes = base62.encode(url.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes, StandardCharsets.US_ASCII);
    }
}

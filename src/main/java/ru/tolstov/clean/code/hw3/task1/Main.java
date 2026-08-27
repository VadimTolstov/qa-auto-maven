package ru.tolstov.clean.code.hw3.task1;

public class Main {
    public static void main(String[] args) {
        ShortenStrategyRegistry.registerShorteningStrategy(StrategyType.BASE62, Base62StrategyFactory::new);
        ShortenStrategyRegistry.registerShorteningStrategy(StrategyType.UUID, UUIDStrategyFactory::new);

        UrlShortenerService urlShortenerService = new UrlShortenerService(
                UrlStorageSingleton.INSTANCE,
                ShortenStrategyRegistry.getShorteningStrategyFactory(StrategyType.BASE62)
        );

        String sortedUrl = urlShortenerService.shortenUrl("https://www.google.com/search?q=java+base62+encode&oq=java+base62+encode&aqs=chrome69i57j0i131i433j0i131i4");
        System.out.println(sortedUrl);
        System.out.println(urlShortenerService.expandUrl(sortedUrl));

        UrlShortenerService urlShortenerServiceUUID = new UrlShortenerService(
                UrlStorageSingleton.INSTANCE,
                ShortenStrategyRegistry.getShorteningStrategyFactory(StrategyType.UUID)
        );

        String sortedUrlUUID = urlShortenerServiceUUID.shortenUrl("https://www.google.com/search?q=java+base62+encode&oq=java+base62+encode&aqs=chrome69i57j0i131i433j0i131i4");
        System.out.println(sortedUrlUUID);
        System.out.println(urlShortenerService.expandUrl(sortedUrlUUID));
    }


}

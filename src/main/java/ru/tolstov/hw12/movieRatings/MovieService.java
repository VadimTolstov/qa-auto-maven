package ru.tolstov.hw12.movieRatings;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class MovieService<T extends Number> {
    private final Map<Movie, List<Rating<T>>> mapRatingsMovies = new ConcurrentHashMap<>();

    public  void  addRating(Movie movie, Rating<T> rating) {
        if (movie == null || rating == null) {
            throw new IllegalArgumentException("movie или rating не должны быть null");
        }
        final double value = rating.estimation().doubleValue();
        if (value <= 0 || value >= 11) {
            throw new IllegalArgumentException("Рейтинг должен быть > 0 и < 11, передан: " + value);
        }
        mapRatingsMovies.computeIfAbsent(movie, r -> new CopyOnWriteArrayList<>()).add(rating);
    }

    public double getAverageRating(Movie movie) {
        List<Rating<T>> ratings = mapRatingsMovies.get(movie);
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }

        return ratings.stream()
                .mapToDouble(r -> r.estimation().doubleValue())
                .average()
                .orElse(0.0);
    }

    public List<Movie> getMoviesSortedByPopularity() {
        return mapRatingsMovies.entrySet().stream()
                .filter(entry -> Objects.nonNull(entry.getValue()) && !entry.getValue().isEmpty())
                .sorted(Map.Entry.<Movie, List<Rating<T>>>comparingByValue(
                        Comparator.comparingDouble((List<Rating<T>> list) ->
                                        list.stream()
                                                .mapToDouble(r -> r.estimation().doubleValue())
                                                .average()
                                                .orElse(0.0))
                                .reversed()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<Movie, Double> getAllAverageRatings() {
        return mapRatingsMovies.entrySet().stream()
                .filter(entry -> Objects.nonNull(entry.getValue()) && !entry.getValue().isEmpty())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(r -> r.estimation().doubleValue())
                                .average()
                                .orElse(0.0)
                ));
    }
}

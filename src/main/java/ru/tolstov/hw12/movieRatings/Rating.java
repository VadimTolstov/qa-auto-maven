package ru.tolstov.hw12.movieRatings;

public record Rating<T extends Number>(T estimation) {
    public Rating {
        if (estimation == null) {
            throw new IllegalArgumentException("estimation не может быть null");
        }
    }
}

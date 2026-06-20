package ru.tolstov.hw12.movieRatings;

public record Movie(String name) {
    public Movie {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name не может быть null или пустым");
        }
    }
}

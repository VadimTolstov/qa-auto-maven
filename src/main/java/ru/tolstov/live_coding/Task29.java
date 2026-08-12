package ru.tolstov.live_coding;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task29 {
    public static List<String> sortLength(List<String> list) {
        Objects.requireNonNull(list);
        return list.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(sortLength(List.of("Как дела", "Привет")).add("Ещ"));
        System.out.println(sortLength(List.of("Как дела", "Привет")));
    }
}

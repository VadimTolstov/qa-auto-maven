package ru.tolstov.live_coding;

import java.util.List;
import java.util.Objects;

public class Task15 {
    public static List<String> filterOdds(List<String> stringList) {
        Objects.requireNonNull(stringList);
        return stringList.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> s.startsWith("А"))
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(filterOdds(List.of("Привет", " Алле", "Караул", "анна", "Алена")));
    }
}

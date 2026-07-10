package ru.tolstov.live_coding;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task17 {
    public static List<Integer> filterOdds(List<Integer> list) {
        Objects.requireNonNull(list);
        return list.stream()
                .filter(Objects::nonNull)
                .filter(e -> e % 2 != 0)
                .collect(Collectors.toList());
    }
}

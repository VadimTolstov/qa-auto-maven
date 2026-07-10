package ru.tolstov.live_coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Task16 {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Objects.requireNonNull(list, "Ссылка на список не должна быть null");
        return list.stream()
                .filter(Objects::nonNull)
                .distinct()
                .toList();
    }

    public static List<Integer> removeDuplicates2(List<Integer> list) {
        Objects.requireNonNull(list, "Ссылка на список не должна быть null");
        return list.isEmpty() ? list : new ArrayList<>(new HashSet<>(list));
    }
}

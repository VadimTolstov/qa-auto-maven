package ru.tolstov.live_coding;

import java.util.List;
import java.util.Objects;

public class Task11 {
    public static int sum(List<Integer> list) {
        Objects.requireNonNull(list);
        int result = 0;
        for (Integer item : list.stream().filter(Objects::nonNull).toList()) {
            result += item;
        }
        return result;
    }


    public static int sum2(List<Integer> list) {
        Objects.requireNonNull(list);
        return list.stream().filter(Objects::nonNull).mapToInt(Integer::valueOf).sum();
    }
}

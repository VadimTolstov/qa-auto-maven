package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task49 {
    public static boolean contains(int[] array, int i) {
        return Arrays.stream(array)
                .filter(e -> e == i)
                .findFirst().isPresent();
    }

    public static boolean contains2(int[] array, int i) {
        return Arrays.stream(array)
                .anyMatch(e -> e == i);
    }
}

package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task38 {
    public static int[] removeDuplicates(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }
}

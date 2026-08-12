package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task55 {
    public static int findMin(int[] array) {
        return Arrays.stream(array)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Массив пуст"));
    }

    public static int findMin2(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Некорректный массив");
        }
        int min = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
}

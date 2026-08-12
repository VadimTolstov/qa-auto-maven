package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task48 {
    public static int countPositive(int[] array) {
        return (int) Arrays.stream(array).filter(i -> i > 0).count();
    }
}

package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task46 {
    public static int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int max2(int[] array) {
        return Arrays.stream(array).max().orElseThrow(() -> new IllegalArgumentException("Массив пуст"));
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(max(new int[]{1, 2, 3, 4, 5, 6,}));
    }

}

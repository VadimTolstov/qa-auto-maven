package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Task3 {
    public static int max(int[] elements) {
        Objects.requireNonNull(elements,"массив не должен быть null");
        return Arrays.stream(elements).max().orElseThrow();
    }

    public static int max2(Integer[] elements) {
        Objects.requireNonNull(elements,"массив не должен быть null");
        return Arrays.stream(elements).filter(Objects::nonNull).max(Integer::compareTo).orElseThrow();
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[3] = -10;
        arr[2] = 3;
        System.out.println(max(arr));

        Integer[] arr2 = new Integer[10];
        arr2[0] = 1;
        arr2[3] = -10;
        arr2[2] = 33;
        System.out.println(max2(arr2));
    }
}

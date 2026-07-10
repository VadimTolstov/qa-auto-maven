package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.Objects;

public class Task2 {
    public static int sum(int[] elements) {
        Objects.requireNonNull(elements, "elements must not be null");
        return Arrays.stream(elements).filter(Objects::nonNull).sum();
    }

    public static int sum2(Integer[] elements) {
        Objects.requireNonNull(elements, "elements must not be null");
        int a = 0;
        for (Integer element : elements) {
            a = (element != null) ? (a + element) : a;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[2] = 3;
        System.out.println(sum(arr));

        Integer[] arr2 = new Integer[10];
        arr2[0] = 1;
        arr2[2] = 5;
        System.out.println(sum2(arr2));
    }
}

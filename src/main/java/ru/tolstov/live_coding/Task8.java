package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.Objects;

public class Task8 {
    public static int secondMax(int[] array) {
        Objects.requireNonNull(array, "Ссылка на массив не должна быть null");
        int[] array1 = Arrays.stream(array).distinct().sorted().toArray();
        if (array1.length < 2) {
            throw new IllegalArgumentException("Массив состоял из дубликатов или из одного элемента");
        }
        return array1[array1.length - 2];
    }

    public static int secondMax2(int[] array) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        Objects.requireNonNull(array, "Ссылка на массив не должна быть null");

        for (int n : array) {
            if (n > max) {
                max = n;
            } else if (n > second && n != max) {
                second = n;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondMax2(new int[]{10,10}));
    }
}

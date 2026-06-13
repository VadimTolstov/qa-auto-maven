package ru.tolstov.hw10;

import java.util.Arrays;

/**
 * Напишите тесты для метода, который находит максимальное число в массиве:
 */
public class Task4 {
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }
}

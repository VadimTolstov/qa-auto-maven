package ru.tolstov.hw10;

import java.util.Arrays;

public class Task14 {
    public double findAverage(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }
}

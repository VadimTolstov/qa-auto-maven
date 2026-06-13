package ru.tolstov.hw10;

import java.util.Arrays;

public class Task8 {
    public int findSecondMax(int[] numbers) {
        return Arrays.stream(numbers).distinct().sorted().skip(numbers.length - 2).findFirst().orElseThrow();
    }
}

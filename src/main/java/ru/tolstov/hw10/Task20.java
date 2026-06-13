package ru.tolstov.hw10;

import java.util.Arrays;

public class Task20 {
    public boolean hasDuplicates(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() != numbers.length;
    }
}

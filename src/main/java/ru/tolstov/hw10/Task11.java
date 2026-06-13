package ru.tolstov.hw10;

import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    public List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}

package ru.tolstov.hw10;

import java.util.List;
import java.util.stream.Collectors;

public class Task15 {
    public List<Integer> mapToLengths(List<String> words) {
        return words.stream().map(String::length).collect(Collectors.toList());
    }
}

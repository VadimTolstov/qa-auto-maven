package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task26 {
    public static Map<String, Integer> wordFreq(String str) {
        Objects.requireNonNull(str);
        Map<String, Integer> map = new HashMap<>();
        String[] strings = str.toLowerCase().split("\\s+");
        Arrays.stream(strings).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        return map;
    }

    public static void main(String[] args) {
        System.out.println(wordFreq("Привет Как как дела Привет"));
    }

}

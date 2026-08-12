package ru.tolstov.live_coding.two;

import java.util.HashMap;
import java.util.Map;

public class WordFreq {
    public static Map<String, Integer> wordFreq(String str) {
        Map<String, Integer> hasMap = new HashMap<>();
        for (String s : str.split(" ")) {
            hasMap.put(s, hasMap.getOrDefault(s, 0) + 1);
        }
        return hasMap;
    }
}

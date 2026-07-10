package ru.tolstov.live_coding;

import java.util.Objects;

public class Task7 {

    public static int countVowels(String str) {
        int i = 0;
        if (Objects.isNull(str) || str.isBlank()) {
            throw new IllegalArgumentException("Строка не может быть null, пуста или состоять из одних пробелов");
        }
        for (char c : str.toLowerCase().toCharArray()) {
            if ("aeiouyёуеаоиюыэя".indexOf(c) >= 0) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("Привет"));
        System.out.println(countVowels("HI"));
        System.out.println(countVowels("H"));
        System.out.println(countVowels(" i"));
    }
}

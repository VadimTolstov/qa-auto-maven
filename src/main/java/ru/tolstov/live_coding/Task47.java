package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task47 {
    public static int countWords(String str) {
        return (int) Arrays.stream(str.split("\\s"))
                .filter(s -> !s.isBlank())
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countWords(" Привет как дела? "));
        System.out.println(countWords(" Привет как  дела? "));
    }
}

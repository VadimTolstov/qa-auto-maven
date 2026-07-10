package ru.tolstov.live_coding;

import java.util.Objects;

public class Task10 {
    public static int countWords(String str) {
        Objects.requireNonNull(str, "Строка не должна быть null");
        return str.isBlank()
                ? 0
                : str.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        System.out.println(countWords(" Привет. Как дела"));
    }
}

package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task41 {
    public static int sum(String str) {
        return Arrays.stream(str.split("[^0-9]"))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static int sumNumbers(String str) {
        int sum = 0;
        int num = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sum = sum + num;
                num = 0;
            }
        }
        return sum + num;
    }

    public static void main(String[] args) {
        System.out.println(sum("123,123A123 123"));
        System.out.println(sum("abc123,123A123 123"));
        System.out.println(sumNumbers("abc123,123A123 123"));
        System.out.println(sumNumbers("123,123A123 123"));
    }
}

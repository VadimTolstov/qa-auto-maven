package ru.tolstov.live_coding;

import java.util.Objects;

public class Task20 {
    public static boolean isNumber(String s) {
        String v = s.trim();
        Objects.requireNonNull(v);
        try {
            Integer.valueOf(v);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("123 "));
        System.out.println(isNumber("12 3 "));
    }
}

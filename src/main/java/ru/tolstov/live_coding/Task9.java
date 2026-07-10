package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.Objects;

public class Task9 {
    public static boolean isAnagram(String a, String b) {
        Objects.requireNonNull(a, "a не должен быть null");
        Objects.requireNonNull(b, "b не должен быть null");
        char[] ca = a.toLowerCase().replaceAll("\\s+", "").toCharArray();
        char[] cb = b.toLowerCase().replaceAll("\\s+", "").toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("l isten", "silent"));        // true
        System.out.println(isAnagram("Азбука", "буква"));        // false (разная длина)
        System.out.println(isAnagram("Азбука", "кабуза"));        // true
        System.out.println(isAnagram("Hello", "World"));          // false
        System.out.println(isAnagram("", ""));                    // true
        System.out.println(isAnagram(null, "abc"));
    }
}

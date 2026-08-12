package ru.tolstov.live_coding.two;

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }

    public static void main(String[] args) {

    }
}

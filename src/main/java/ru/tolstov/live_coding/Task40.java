package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task40 {
    public static boolean isAnagram(String a, String b) {
        char[] arrayCharA = a.toCharArray();
        char[] arrayCharB = b.toCharArray();
        Arrays.sort(arrayCharA);
        Arrays.sort(arrayCharB);
        return Arrays.equals(arrayCharA, arrayCharB);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abs","bsa"));
    }
}

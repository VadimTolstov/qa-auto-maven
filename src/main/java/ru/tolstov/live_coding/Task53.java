package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task53 {
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseString2(String str) {
        int left = 0;
        int right = str.length() - 1;
        char element;
        char[] arrayChar = str.toCharArray();
        while (left < right) {
            element = arrayChar[left];
            arrayChar[left++] = arrayChar[right];
            arrayChar[right--] = element;
        }
        return new String(arrayChar);
    }
}

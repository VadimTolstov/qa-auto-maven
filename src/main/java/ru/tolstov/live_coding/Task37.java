package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task37 {
    public static boolean isPalindrome(String str) {
        String filterStr = str.replaceAll("\\s+", "").replaceAll("[^A-Za-zA-Яа-яёЁ]","").toLowerCase();
        return new StringBuilder(filterStr).reverse().toString().equals(filterStr);
    }


    public static boolean isPalindrome2(String str) {
        String filterStr = str.replaceAll("[^A-Za-zA-Яа-яёЁ]","").toLowerCase();
        int i = 0;
        int j = filterStr.length() - 1;
        char elementI;
        char[] arrayChar = filterStr.toCharArray();
        while (i < j) {
            elementI = arrayChar[i];
            arrayChar[i] = arrayChar[j];
            arrayChar[j] = elementI;
            i++;
            j--;
        }
       return Arrays.equals(filterStr.toCharArray(), arrayChar);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" Tat , "));
        System.out.println(isPalindrome2(" Tat , "));
    }
}

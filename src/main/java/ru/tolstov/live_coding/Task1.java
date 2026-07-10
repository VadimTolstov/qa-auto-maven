package ru.tolstov.live_coding;

import java.util.Objects;

public class Task1 {
    public static boolean isPalindrome(String str) {
        Objects.requireNonNull(str, "str must not be null");
       if(str.isBlank()) {
           throw new IllegalArgumentException("str must not be empty");
       }

       String clean = str.replaceAll("\\s+","").toLowerCase();
       return new StringBuilder(clean).reverse().toString().equals(clean);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Aba"));
        System.out.println(isPalindrome("A2A"));
        System.out.println(isPalindrome("AA bb AA"));
        System.out.println(isPalindrome("AA b A"));
    }
}

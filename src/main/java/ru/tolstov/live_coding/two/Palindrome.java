package ru.tolstov.live_coding.two;

public class Palindrome {
    private static boolean isPalindrome(int n) {
        int rev = 0;
        int original = n;

        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev == original;
    }
}

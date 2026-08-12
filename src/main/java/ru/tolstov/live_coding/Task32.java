package ru.tolstov.live_coding;

public class Task32 {
    public static boolean isPalindrome(int n) {
        int rev = 0, original = n;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return original == rev;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
    }
}

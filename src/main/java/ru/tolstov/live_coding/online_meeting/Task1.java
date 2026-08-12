package ru.tolstov.live_coding.online_meeting;

public class Task1 {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        boolean result = true;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("aaba"));
    }
}

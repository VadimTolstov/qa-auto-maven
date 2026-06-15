package ru.tolstov.hw11;

/**
 * Код должен проверить, является ли строка палиндромом, но выбрасывает NullPointerException.
 */
public class DebugTask4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("str is null or empty");
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
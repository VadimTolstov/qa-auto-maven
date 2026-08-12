package ru.tolstov.live_coding;

public class Task42 {
    public static boolean startsWith(String word, String prefix) {
        if (word.length() < prefix.length()) return false;
        for (int i = 0; i < prefix.length(); i++) {
            if (word.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

package ru.tolstov.live_coding;

public class Task54 {
    public static String removeVowels(String str) {
        return str.replaceAll("(?i)[aeiyuo]", "");
    }
}

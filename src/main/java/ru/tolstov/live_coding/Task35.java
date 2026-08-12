package ru.tolstov.live_coding;

public class Task35 {
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        System.out.println(removeSpaces("КАк так"));
        System.out.println(removeSpaces("КАк так "));
        System.out.println(removeSpaces(" КАк так "));
    }
}

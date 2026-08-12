package ru.tolstov.live_coding.two;

public class Concatenation {

    private static String concatenation(String[] str) {
        StringBuilder resultString = new StringBuilder();
        for (String s : str) {
            resultString.append(s).append(" ");
        }
        return resultString.toString().trim();
    }
}

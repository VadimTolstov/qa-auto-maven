package ru.tolstov.live_coding.two;

public class Glasn {
    public static int glasn(String str) {
        return str.replaceAll("(?i)[^aeqyuio]", "").length();
    }

    public static void main(String[] args) {
        System.out.println(glasn("SQqol"));
    }
}

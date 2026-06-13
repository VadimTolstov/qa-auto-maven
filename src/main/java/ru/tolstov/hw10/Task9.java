package ru.tolstov.hw10;

public class Task9 {
    public int countWords(String sentence) {
        return sentence.trim().isEmpty() ? 0 : sentence.split("\\s+").length;
    }
}

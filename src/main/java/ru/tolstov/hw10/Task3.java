package ru.tolstov.hw10;

/**
 * Напишите тесты для метода, который переворачивает строку:
 */
public class Task3 {

    public String reverse(String input) {
        if (input == null) return null;
        return  new StringBuilder(input).reverse().toString();
    }
}

package ru.tolstov.hw10;

/**
 * Напишите тесты для метода, который считает количество гласных букв в строке:
 * Разные строки ("hello", "java", "AEIOU", "")
 * null (должно выбрасываться исключение)
 * Строки без гласных
 */
public class Task2 {

    public int countVowels(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return (int) input.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }
}

package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {
    /**
     * Тесты для проверки, подсчета гласных букв в строке
     * позитивные:
     * - "hello" -> 2
     * - "HHHH" -> 0
     * - "hElp" -> 1
     * - "VADIM" -> 2
     * - "My Family" -> 2
     * граничные:
     * - null ->  IllegalArgumentException("Input cannot be null");
     * - "" -> 0
     * - " " -> 0
     * - "21@!$" -> 0
     */

    public static Stream<Arguments> stringForValidationPositiveCases() {
        return Stream.of(
                Arguments.of("hello", 2),
                Arguments.of("HHHH", 0),
                Arguments.of("hElp", 1),
                Arguments.of("VADIM", 2),
                Arguments.of("My Family", 2),
                Arguments.of("My Family", 2),
                Arguments.of("", 0),
                Arguments.of(" ", 0),
                Arguments.of("21@!$", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("stringForValidationPositiveCases")
    void checkIfValidStringsCountVowels(String initialString, int expectedResult) {
        assertEquals(
                expectedResult,
                new Task2().countVowels(initialString),
                "Ожидали получить значение " + expectedResult + " от переданного значения " + initialString
        );
    }

    @Test
    void checkExceptionIfStringNullCountVowels() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task2().countVowels(null);
        }, "Ожидаем IllegalArgumentException");
        assertEquals(
                "Input cannot be null",
                exception.getMessage());
    }
}
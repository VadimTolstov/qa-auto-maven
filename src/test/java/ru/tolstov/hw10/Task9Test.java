package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task9Test {
    /**
     * Тесты для проверки, количество слов в строке:
     * позитивные:
     * - "Hello world" ->	2
     * - "One" ->	1
     * - " Leading and trailing " ->	3
     * - "Multiple spaces between" ->	3
     * - "Tab\tseparated\twords" ->	3
     * - "New\nline\nseparator"	 ->	3
     * - "Mixed \t\n separators" ->	3
     * - " " (два пробела) ->	0
     * - ""  ->	0
     * - "\t\n\r" ->	0
     * - "word" ->	1
     * - "word with punctuation, like this." ->	5
     * граничные:
     * - " a "	1
     * - "a b"	2
     * - "Hello\t\tworld\n\n!"	3
     * негативные:
     * - null	IllegalArgumentException ?????????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of("Hello world", 2),
                Arguments.of("One", 1),
                Arguments.of(" Leading and trailing ", 3),
                Arguments.of("Multiple spaces between", 3),
                Arguments.of("Tab\tseparated\twords", 3),
                Arguments.of("New\nline\nseparator", 3),
                Arguments.of("Mixed \t\n separators", 2),
                Arguments.of(" ", 0),
                Arguments.of("", 0),
                Arguments.of("\t\n\r", 0),
                Arguments.of("word", 1),
                Arguments.of("word with punctuation, like this.", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidCountWords(String actual, int expected) {
        assertEquals(expected, new Task9().countWords(actual));
    }


    public static Stream<Arguments> dataForValidationBoundaryCases() {
        return Stream.of(
                Arguments.of(" a ", 1),
                Arguments.of("a b", 2),
                Arguments.of("Hello\t\tworld\n\n!", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationBoundaryCases")
    void checkIfValidFindSecondMaxBoundaryCases(String actual, int expected) {
        assertEquals(expected, new Task9().countWords(actual));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task9().countWords(null));
    }
}
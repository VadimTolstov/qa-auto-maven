package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task15Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - ["hello", "world"] ->	[5, 5]
     * - ["a", "abc", "ab"] ->[1, 3, 2]
     * - ["", "test", ""] ->[0, 4, 0]
     * - []	 -> []
     * - ["onlyOne"]	 -> [7]
     * - [" spaces "]	 -> [10]
     * граничные:
     * - [" ", ""] ->	[0, 4, 0]
     * - ["😊", "😊😊"] 	 -> [2, 4]
     * негативные:
     * - null	 -> IllegalArgumentException ?????????
     * - ["abc", null, "def"] ->	IllegalArgumentException ?????????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(List.of("hello", "world"), List.of(5, 5)),
                Arguments.of(List.of("a", "abc", "ab"), List.of(1, 3, 2)),
                Arguments.of(List.of("", "test", ""), List.of(0, 4, 0)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of("onlyOne"), List.of(7)),
                Arguments.of(List.of(" spaces "), List.of(8)),
                Arguments.of(List.of(" ", ""), List.of(1, 0)),
                Arguments.of(List.of("😊", "😊😊"), List.of(2, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidListToLengths(List<String> actual, List<Integer> expected) {
        assertEquals(expected, new Task15().mapToLengths(actual));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task15().mapToLengths(null));
    }

    @Test
    void checkExceptionIfListContainsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task15().mapToLengths(List.of("abc", null, "def")));
    }
}
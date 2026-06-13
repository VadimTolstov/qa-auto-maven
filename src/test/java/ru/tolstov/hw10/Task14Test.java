package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task14Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - [1, 2, 3] ->	2.0
     * - [5] ->	5.0
     * - [-5, 5] ->	0.0
     * - [10, 20, 30, 40] ->	25.0
     * - [-10, -20, -30] ->	-20.0
     * - [1, 2, 3, 4, 5] ->	3.0
     * - [1, 2, 4] ->	2.3333333333333335
     * граничные:
     * - [0, 0, 0] ->	0.0
     * - [Integer.MAX_VALUE, Integer.MIN_VALUE] ->	-0.5
     * - [Integer.MAX_VALUE, Integer.MAX_VALUE] ->	2147483647.0
     * негативные:
     * - [] ->	IllegalArgumentException ?????????
     * - null ->	IllegalArgumentException ?????????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2.0),
                Arguments.of(new int[]{5}, 5.0),
                Arguments.of(new int[]{-5, 5}, 0.0),
                Arguments.of(new int[]{10, 20, 30, 40}, 25.0),
                Arguments.of(new int[]{-10, -20, -30}, -20.0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3.0),
                Arguments.of(new int[]{1, 2, 4}, 2.3333333333333335),
                Arguments.of(new int[]{0, 0, 0}, 0.0),
                Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, -0.5),
                Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2147483647.0)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidArrayToFindAverage(int[] actual, double expected) {
        assertEquals(expected, new Task14().findAverage(actual));
    }

    @Test
    void checkExceptionIfArrayIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task14().findAverage(new int[]{}));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task14().findAverage(null));
    }
}
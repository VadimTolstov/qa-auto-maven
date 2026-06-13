package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task20Test {
    /**
     * Тесты для проверки, количество слов в строке:
     * позитивные:
     * - [1, 2, 3, 4]	false
     * - [1, 2, 2, 3]	true
     * - [1, 1, 1, 1]	true
     * - [] 	false
     * - [5]	false
     * - [Integer.MAX_VALUE, Integer.MAX_VALUE]	true
     * - [-1, -2, -3, -1]	true
     * - [0, 0, 1, 2]	true
     * - [1, 2, 3, 1, 2]	true
     * негативные:
     * - null	IllegalArgumentException ?????????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 2, 3}),
                Arguments.of((Object) new int[]{1, 1, 1, 1}),
                Arguments.of((Object) new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}),
                Arguments.of((Object) new int[]{-1, -2, -3, -1}),
                Arguments.of((Object) new int[]{0, 0, 1, 2}),
                Arguments.of((Object) new int[]{1, 2, 3, 1, 2})

        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidArrayHasDuplicates(int[] actual) {
        assertTrue(new Task20().hasDuplicates(actual));
    }

    public static Stream<Arguments> dataForValidationInvalidCases() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 2, 3, 4}),
                Arguments.of((Object) new int[]{}),
                Arguments.of((Object) new int[]{5})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationInvalidCases")
    void checkIfArgumentInvalidHasDuplicates(int[] actual) {
        assertFalse(new Task20().hasDuplicates(actual));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task20().hasDuplicates(null));
    }
}
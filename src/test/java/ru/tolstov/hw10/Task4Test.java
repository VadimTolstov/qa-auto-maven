package ru.tolstov.hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;


class Task4Test {
    /**
     * Тесты для проверки, нахождения максимального числа в массиве
     * позитивные:
     * - [3, 5, 7, 2] -> 7
     * - [5] -> 5
     * - [-10,-99] -> -10
     * граничные
     * - []
     */

    public static Stream<Arguments> arrayForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 5, 7, 2}, 7),
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{-10, -99}, -10));
    }

    @ParameterizedTest
    @MethodSource("arrayForValidationPositiveCases")
    void checkIfValidArrayFindMaxNumber(int[] array, int expectedResult) {
        Assertions.assertEquals(expectedResult, new Task4().findMax(array));
    }


    @Test
    void checkExceptionIfInvalidArray() {
        NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            new Task4().findMax(new int[]{});
        }, "Ожидаем NoSuchElementException");

        Assertions.assertEquals(
                "No value present",
                exception.getMessage()
        );
    }
}
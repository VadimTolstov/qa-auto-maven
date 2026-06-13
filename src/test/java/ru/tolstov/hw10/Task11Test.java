package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task11Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - [2, 4, 6, 8] ->	[2, 4, 6, 8]
     * - [1, 3, 5] ->	[]
     * - [1, 2, 3, 4, 5, 6] ->	[2, 4, 6]
     * - [-2, -4, -6] ->	[-2, -4, -6]
     * - [-1, -2, -3, -4] ->	[-2, -4]
     * граничные:
     * - [0] ->	[0]
     * - [] -> []
     * - [Integer.MAX_VALUE] ->	[]
     * - [Integer.MAX_VALUE - 1] ->	[2147483646]
     * - [2147483647, 2147483646] ->	[2147483646]
     * негативные:
     * - [2, null, 4] ->	IllegalArgumentException ?????????
     * - [null] ->	IllegalArgumentException ?????????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(List.of(2, 4, 6, 8), List.of(2, 4, 6, 8)),
                Arguments.of(List.of(1, 3, 5), List.of()),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 4, 6)),
                Arguments.of(List.of(-2, -4, -6), List.of(-2, -4, -6)),
                Arguments.of(List.of(-1, -2, -3, -4), List.of(-2, -4)),
                Arguments.of(List.of(0), List.of(0)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(Integer.MAX_VALUE), List.of()),
                Arguments.of(List.of(Integer.MAX_VALUE - 1), List.of(2147483646)),
                Arguments.of(List.of(2147483647, 2147483646), List.of(2147483646))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidListToFilterEvenNumbers(List<Integer> numbers, List<Integer> expected) {
        assertEquals(expected, new Task11().filterEvenNumbers(numbers));
    }

    @Test
    void checkIfInvalidListToFilterEvenNumbers() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task11().filterEvenNumbers(List.of(2, null, 4)));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task11().filterEvenNumbers(null));
    }
}
package ru.tolstov.hw10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task7Test {
    /**
     * Тесты для проверки, факториал числа:
     * позитивные:
     * - 0 -> 1
     * - 1 -> 1
     * - 2 -> 2
     * - 3 -> 6
     * - 5 -> 120
     * - 6 -> 720
     * - 10 -> 3628800
     * - 12 -> 479001600
     * негативные:
     * - -1 -> Ошибка (отрицательное число)
     * - 21 -> Ошибка переполнения
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(5, 120),
                Arguments.of(6, 720),
                Arguments.of(10, 3628800),
                Arguments.of(12, 479001600)

        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidFactorial(int actualFactorial, int expectedFactorial) {
        assertEquals(expectedFactorial, new Task7().factorial(actualFactorial));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            21
    })
    void checkIfInvalidFactorial(int actualFactorial) {
        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> new Task7().factorial(actualFactorial)
        );
        assertEquals("Negative numbers not allowed", illegalArgumentException.getMessage());
    }
}
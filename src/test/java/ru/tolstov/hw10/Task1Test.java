package ru.tolstov.hw10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task1Test {

    /**
     * Тесты для проверки, является ли число четным
     * позитивные:
     * - 4 -> true
     * - 66 - true
     * - 0 -> true
     * - -10 -> true
     * негативные кейсы:
     * - 33 -> false
     * - 3 -> false
     * - -3 -> false
     */
    @ParameterizedTest
    @ValueSource(ints = {
            4,
            66,
            0,
            -10
    })
    void checkIfValidNumberIsEven(int value) {
        assertTrue(new Task1().isEven(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            33,
            3,
            -3
    })
    void checkIfValidNumberIsNotEven(int value) {
        assertFalse(new Task1().isEven(value));
    }
}
package ru.tolstov.hw10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task5Test {

    /**
     * Тесты для проверки, является ли год високосным
     * позитивные:
     * - 2026 -> false
     * - 2030 -> false
     * - 2000 -> true
     * - 2020 -> true
     * - 2100 -> false
     * - 1900 -> false
     * граничные:
     * - 1 -> false
     * негативные:
     * - 0
     * - 100
     */


    @ParameterizedTest
    @ValueSource(ints = {
            2000,
            2020
    })
    void checkIfYearLeapYear(int year) {
        assertTrue(new Task5().isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            2026,
            2030,
            2110,
            2100,
            1900
    })
    void checkIfYearNotLeapYear(int year) {
        assertFalse(new Task5().isLeapYear(year));
    }

    /**
     * Нет проверки в методе на значения больше нуля.
     */
    @ParameterizedTest
    @ValueSource(ints = {
            0,
           -100
    })
    void checkNegativeCases (int year) {
        assertFalse(new Task5().isLeapYear(year));
    }
}
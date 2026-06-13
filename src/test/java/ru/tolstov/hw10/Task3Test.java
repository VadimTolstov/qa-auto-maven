package ru.tolstov.hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Task3Test {
    /**
     * Тесты для проверки, разворота строки
     * позитивные:
     * - алла -> алла
     * - Привет -> тевирП
     * - Л -> Л
     * - Как СкАжешь -> ьшежАкС каК
     * - 321@#!  -> !#@123
     * граничные
     * - null -> null
     * - "" -> ""
     * - " " -> " "
     */

    public static Stream<Arguments> stringForValidationPositiveCases() {
        return Stream.of(
                Arguments.of("алла", "алла"),
                Arguments.of("Привет", "тевирП"),
                Arguments.of("Л", "Л"),
                Arguments.of("Как СкАжешь", "ьшежАкС каК"),
                Arguments.of("321@#!", "!#@123"),
                Arguments.of("", ""),
                Arguments.of(" ", " ")
        );
    }

    @ParameterizedTest
    @MethodSource("stringForValidationPositiveCases")
    void checkIfValidStringsReverse(String initialString, String expectedResult) {
        Assertions.assertEquals(expectedResult, new Task3().reverse(initialString));
    }

    public static Stream<Arguments> stringForValidationBoundaryCases() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(" ", " ")
        );
    }

    @ParameterizedTest
    @MethodSource("stringForValidationBoundaryCases")
    void voidCheckingBoundaryCasesReverse(String initialString, String expectedResult) {
        Assertions.assertEquals(expectedResult, new Task3().reverse(initialString));
    }

    @Test
    void voidCheckingReturnNullCasesReverse() {
        Assertions.assertNull(new Task3().reverse(null));
    }
}
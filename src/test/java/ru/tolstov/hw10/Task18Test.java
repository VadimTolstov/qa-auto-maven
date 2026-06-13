package ru.tolstov.hw10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task18Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * -	a	b	Ор
     * -	18, 12, 6
     * -	12, 18, 6
     * -	0, 5, 5
     * -	5, 0, 5
     * -	0, 0, 0
     * -	1, 1, 1
     * -	17, 13, 1
     * -	-18, 12, 6
     * -	18, -12, -6
     * -	-18, -12, -6
     * -	-6, 3, 3
     * -	6, -3, -3
     * -	0, -5, -5
     * -	-5, 0, -5
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(18, 12, 6),
                Arguments.of(12, 18, 6),
                Arguments.of(0, 5, 5),
                Arguments.of(5, 0, 5),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(17, 13, 1),
                Arguments.of(-18, 12, 6),
                Arguments.of(18, -12, -6),
                Arguments.of(-18, -12, -6),
                Arguments.of(-6, 3, 3),
                Arguments.of(6, -3, -3),
                Arguments.of(0, -5, -5),
                Arguments.of(-5, 0, -5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidData(int a, int b, int expected) {
        assertEquals(expected, new Task18().gcd(a, b));
    }

}
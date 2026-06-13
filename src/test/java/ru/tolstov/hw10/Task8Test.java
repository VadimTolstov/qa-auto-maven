package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task8Test {
    /**
     * Тесты для проверки, найти второе по величине число в массиве:
     * позитивные:
     * - [1, 2, 3] -> 2
     * - [5, 3, 9, 1] -> 5
     * - [10, 20] -> 10
     * - [-5, -1, -3, -2] -> -2
     * - [2, 2, 3, 3, 1] -> 2
     * граничные: В этих кейсах больше вопросов, метод должен возвращать ошибку и какую если дубли и тд?
     * - [5,5,5] исключение (нет второго уникального)
     * - [2,2,1,3,3] -> 2
     * - [3, 3, 2, 1] -> 2
     * - [0, 0, 0, -1] -> -1
     * - [2, 2, 3, 3, 1] -> 2
     * - [42, 42] (дубликаты)	Возвращает 42 (максимум, а не второй максимум)
     * негативные:
     * - null	IllegalArgumentException
     * - [] (пустой массив)	-> IllegalArgumentException
     * - [7] -> должно быть исключения т.к число одно в массиве или вернем одно число????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{5, 3, 9, 1}, 5),
                Arguments.of(new int[]{10, 20}, 10),
                Arguments.of(new int[]{-5, -1, -3, -2}, -2),
                Arguments.of(new int[]{2,2,3,3,1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidFindSecondMax(int[] actual, int expected) {
        assertEquals(expected, new Task8().findSecondMax(actual));
    }

    //у некоторых кейсов некорректный ожидаемый результат т.к не понятно на данном этапе реализации,
    // что является корректным ожидаемым результатом в реализации метода Task8().findSecondMax(),
    // например когда дубли или числа два и они дубли, какое сообщение он должен выбросить или вернуть из них максимум?
    public static Stream<Arguments> dataForValidationBoundaryCases() {
        return Stream.of(
                Arguments.of(new int[]{5, 5, 5}, 5),
                Arguments.of(new int[]{2, 2, 1, 3, 3}, 2),
                Arguments.of(new int[]{3, 3, 2, 1}, 2),
                Arguments.of(new int[]{0, 0, 0, -1}, -1),
                Arguments.of(new int[]{2, 2, 3, 3, 1}, 2),
                Arguments.of(new int[]{42, 42}, 42)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationBoundaryCases")
    void checkIfValidFindSecondMaxBoundaryCases(int[] actual, int expected) {
        assertEquals(expected, new Task8().findSecondMax(actual));
    }

    @Test
    void checkExceptionIfArrayIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task8().findSecondMax(new int[]{}));

    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task8().findSecondMax(null));

    }

    @Test
    void checkExceptionIfOneArgumentInArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task8().findSecondMax(new int[]{1}));

    }
}

package ru.tolstov.hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class Task12Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - ["a", "bb", "ccc"]	-> ["a", "bb", "ccc"]
     * - ["ccc", "bb", "a"]	-> ["a", "bb", "ccc"]
     * - ["", "a", "ab"]	-> ["", "a", "ab"]
     * - ["ab", "a", ""]	-> ["", "a", "ab"]
     * - ["same", "same", "same"]	-> ["same", "same", "same"]
     * - ["abc", "a", "bc", "ab"]	->  ["a","bc","ab","abc"]
     * - ["longest", "shrt", "med"]	-> ["med", "shrt",  "longest"]
     * <p>
     * граничные:
     * - [] 	-> []
     * - ["hello", "world"] (одинаковая длина) ->	["hello", "world"]
     * негативные:
     * - null ->	IllegalArgumentException ?????????
     * - ["a", null, "bc"]	-> IllegalArgumentException ?????????
     */
    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(List.of("a", "bb", "ccc"), List.of("a", "bb", "ccc")),
                Arguments.of(List.of("ccc", "bb", "a"), List.of("a", "bb", "ccc")),
                Arguments.of(List.of("", "a", "ab"), List.of("", "a", "ab")),
                Arguments.of(List.of("ab", "a", ""), List.of("", "a", "ab")),
                Arguments.of(List.of("same", "same", "same"), List.of("same", "same", "same")),
                Arguments.of(List.of("abc", "a", "bc", "ab"), List.of("a", "bc", "ab", "abc")),
                Arguments.of(List.of("longest", "shrt", "med"), List.of("med", "shrt", "longest")),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of("hello", "world"), List.of("hello", "world"))

        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidListToSortByLength(List<String> actual, List<String> expected) {
        Assertions.assertEquals(expected, new Task12().sortByLength(actual));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task12().sortByLength(null));
    }

    @Test
    void checkIfInvalidListToSortByLength() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task12().sortByLength(List.of("a", null, "bc")));
    }
}
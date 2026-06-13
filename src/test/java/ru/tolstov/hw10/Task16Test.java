package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task16Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - "a,b,c" ,	","  ->	["a", "b", "c"]
     * - "hello world java" ,	" " ->	["hello", "world", "java"]
     * - "one|two|three" ,	"\\|" ->	["one", "two", "three"]
     * - "a.b.c"	 , "\\." ->	["a", "b", "c"]
     * - "a*b*c"	 , "\\*" ->	["a", "b", "c"]
     * - "a+b+c"	 , "\\+" ->	["a", "b", "c"]
     * - "a b c"	 , "\\s+" ->	["a", "b", "c"]
     * - "a\nb\nc"	 , "\n"	 ->["a", "b", "c"]
     * граничные:
     * - ""	, ","	 -> [""]
     * - "a,,c"	, "," -> 	["a", "", "c"]
     * - "a,b,c," ,	","  ->	["a","b","c"]
     * - "abc"	, ""  ->	["a", "b", "c"]
     * - "a\\b\\c"	, "\\\\" ->	["a", "b", "c"]
     * - "a$b$c"	, "\\$" ->	["a", "b", "c"]
     * - "a^b^c"	, "\\^" ->	["a", "b", "c"]
     * - "a?b?c"	, "\\?" ->	["a", "b", "c"]
     * негативные:
     * - null	, ","  ->	IllegalArgumentException ?????????
     * - "abc"	, null ->	IllegalArgumentException ?????????
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of("a,b,c", ",", new String[]{"a", "b", "c"}),
                Arguments.of("hello world java", " ", new String[]{"hello", "world", "java"}),
                Arguments.of("one|two|three", "\\|", new String[]{"one", "two", "three"}),
                Arguments.of("a.b.c", "\\.", new String[]{"a", "b", "c"}),
                Arguments.of("a*b*c", "\\*", new String[]{"a", "b", "c"}),
                Arguments.of("a+b+c", "\\+", new String[]{"a", "b", "c"}),
                Arguments.of("a b c", "\\s+", new String[]{"a", "b", "c"}),
                Arguments.of("a\nb\nc", "\n", new String[]{"a", "b", "c"}),
                Arguments.of("", ",", new String[]{""}),
                Arguments.of("a,,c", ",", new String[]{"a", "", "c"}),
                Arguments.of("a,b,c,", ",", new String[]{"a", "b", "c"}),
                Arguments.of("abc", "", new String[]{"a", "b", "c"}),
                Arguments.of("a\\b\\c", "\\\\", new String[]{"a", "b", "c"}),
                Arguments.of("a$b$c", "\\$", new String[]{"a", "b", "c"}),
                Arguments.of("a^b^c", "\\^", new String[]{"a", "b", "c"}),
                Arguments.of("a?b?c", "\\?", new String[]{"a", "b", "c"})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidSplitString(String actual, String divider, String[] expected) {
        assertTrue(Arrays.equals(expected, new Task16().splitString(actual, divider)));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task16().splitString(null, ","));
    }

    @Test
    void checkExceptionIfDelimiterNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task16().splitString("abc", null));
    }
}
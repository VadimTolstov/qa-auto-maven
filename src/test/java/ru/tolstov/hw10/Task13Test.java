package ru.tolstov.hw10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task13Test {

    /**
     * Тесты для проверки:
     * позитивные:
     * - "listen"	"silent" ->	true
     * - "Listen"	"silent" ->	true
     * - "hello"	"hello" ->	true
     * - "hello"	"holle" ->	true
     * - "Astronomer"	"Moon starer" ->	true
     * - "a b c"	"cba" ->	true
     * - "aabbcc"	"abcabc" ->	true
     * - "A decimal point"	"I'm a dot in place" ->	false
     * - "abc"	"abd" ->	false
     * - "abc"	"ab" ->	false
     * - "abc"	null ->	false
     * - "abc!"	"cba" ->	false
     * граничные:
     * - "Conversation"	"Voices rant on" ->	true
     * - "" 	"" ->	true
     * - " " 	"" ->	true
     * - "abc"	"ABC"	 ->true
     * - "abc!"	"!cba"	 ->true
     * - null	"abc"	 ->false
     * - null	null	 ->false
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of("listen", "silent"),
                Arguments.of("Listen", "silent"),
                Arguments.of("hello", "hello"),
                Arguments.of("hello", "holle"),
                Arguments.of("Astronomer", "Moon starer"),
                Arguments.of("a b c", "cba"),
                Arguments.of("aabbcc", "abcabc"),
                Arguments.of("Conversation", "Voices rant on"),
                Arguments.of("", ""),
                Arguments.of(" ", ""),
                Arguments.of("abc", "ABC"),
                Arguments.of("abc!", "!cba")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkIfValidStringsAnagram(String str1, String str2) {
        assertTrue(new Task13().isAnagram(str1, str2));
    }

    public static Stream<Arguments> dataForValidationNegativeCases() {
        return Stream.of(
                Arguments.of("A decimal point", "I'm a dot in place"),
                Arguments.of("abc", "abd"),
                Arguments.of("abc", "ab"),
                Arguments.of("abc", null),
                Arguments.of("abc!", "cba"),
                Arguments.of(null, "abc"),
                Arguments.of(null, null)

        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationNegativeCases")
    void checkIfInvalidStringsAnagram(String str1, String str2) {
        assertFalse(new Task13().isAnagram(str1, str2));
    }

}
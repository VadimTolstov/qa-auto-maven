package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task19Test {
    /**
     * Тесты для проверки, количество слов в строке:
     * позитивные:
     * - "{\"name\":\"John\"}"	true
     * - "{}"	true
     * - "[1,2,3]"	true
     * - "[]"	true
     * - "\"hello\""	true
     * - "123"	true
     * - "true"	true
     * - "false"	true
     * - "null"	true
     * - " {\"a\":1} "	true
     * - "" (пустая строка)	false
     * - " " (только пробелы)	false
     * - "{name: \"John\"}"	false
     * - "{\"name\": John}"	false
     * - "{'name':'John'}"	false
     * - "{name: 'John'}"	false
     * - "{\"name\":\"John\",}"	false
     * - "[1,2,]"	false
     * - "{\"a\": 1, \"b\": }"	false
     * - "{\"a\": }"	false
     * - "{\"a\": 1 \"b\": 2}"	false
     * - "unquoted"	false
     * - "{\"a\": 1" 	false
     * - "[1,2,3"	false
     * - "{ \"a\": [1, true, null] }"	true
     * граничные:
     * - null	false
     */

    @ParameterizedTest
    @ValueSource(strings = {
            "{\"name\":\"John\"}",
            "{}",
            "[1,2,3]",
            "[]",
            "\"hello\"",
            "123",
            "true",
            "false",
            "null",
            " {\"a\":1} ",
            "{ \"a\": [1, true, null] }"
    })
    void checkIfValidJson(String expected) {
        assertTrue(new Task19().isValidJson(expected));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ",
            "{name: \"John\"}",
            "{\"name\": John}",
            "{'name':'John'}",
            "{name: 'John'}",
            "{\"name\":\"John\",}",
            "[1,2,]",
            "{\"a\": 1, \"b\": }",
            "{\"a\": }",
            "{\"a\": 1 \"b\": 2}",
            "unquoted",
            "{\"a\": 1",
            "[1,2,3"
    })
    void checkIfInvalidJson(String expected) {
        assertFalse(new Task19().isValidJson(expected));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertFalse(new Task19().isValidJson(null));
    }
}
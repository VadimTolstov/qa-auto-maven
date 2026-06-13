package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task17Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - "Password1"	true
     * - "A1abcdef"	true
     * - "MyPass99"	true
     * - "1234Abcd"	true
     * - "Pass1234"	true
     * - "P@ssw0rd"	true
     * - "PASSWORD123"	true
     * - "Password1!"	true
     * - ""  	false
     * - "short" 	false
     * граничные:
     * - "12345678" 	false
     * - "abcdefgh" 	false
     * - "ABCDEFGH" 	false
     * - "Abcdefgh" 	false
     * - "1234abcd" 	false
     * - "Password" false
     * - "pass1234" 	false
     * - "A1" false
     * - null	false
     */

    @ParameterizedTest
    @ValueSource(strings = {
            "Password1",
            "A1abcdef",
            "MyPass99",
            "1234Abcd",
            "Pass1234",
            "P@ssw0rd",
            "PASSWORD123",
            "Password1!"
    })
    void checkIfValidPassword(String actual) {
        assertTrue(new Task17().isValidPassword(actual));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "short",
            "12345678",
            "abcdefgh",
            "ABCDEFGH",
            "Abcdefgh",
            "1234abcd",
            "Password",
            "pass1234",
            "A1"


    })
    void checkIfInvalidPassword(String actual) {
        assertFalse(new Task17().isValidPassword(actual));
    }

    @Test
    void checkIfArgumentNull() {
        assertFalse(new Task17().isValidPassword(null));

    }
}
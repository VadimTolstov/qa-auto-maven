package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task10Test {
    /**
     * Тесты для проверки:
     * позитивные:
     * - "+7 1234567890"	true
     * - "+44 1234567890"	true
     * - "+123 1234567890"	true
     * - "+7 123456789"	false
     * - "+7 12345678901"	false
     * - "7 1234567890"	false
     * - "+7 1234567890 "	false
     * - " +7 1234567890"	false
     * - "+71234567890"	false
     * - "+7 123 456 7890"	false
     * - "+7 123456789a"	false
     * - " +7 1234567890 "  false
     * - "" 	false
     * граничные:
     * - "+000 1234567890"	true
     * - "+7 0000000000"	true
     * негативные:
     * - null	IllegalArgumentException ?????????
     */


    @ParameterizedTest
    @ValueSource(strings = {
            "+7 1234567890",
            "+44 1234567890",
            "+123 1234567890",
            "+000 1234567890",
            "+7 0000000000"
    })
    void checkIfValidPhoneNumber(String phoneNumber) {
        assertTrue(new Task10().isValidPhoneNumber(phoneNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+7 123456789",
            "+7 12345678901",
            "7 1234567890",
            "+7 1234567890 ",
            " +7 1234567890",
            "+71234567890",
            "+7 123 456 7890",
            "+7 123456789a",
            " +7 1234567890 ",
            "71234567890",
            ""
    })
    void checkIfInvalidPhoneNumber(String phoneNumber) {
        assertFalse(new Task10().isValidPhoneNumber(phoneNumber));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task10().isValidPhoneNumber(null));

    }
}
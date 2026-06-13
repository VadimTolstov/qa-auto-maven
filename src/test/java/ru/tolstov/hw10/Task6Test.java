package ru.tolstov.hw10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task6Test {

    /**
     * Тесты для проверки, является ли строка валидным email
     * позитивные (email-адресов (по стандарту RFC 5322)):
     * - "test@example.com" -> true
     * - simple@example.com -> true
     * - user.name+tag@domain.co.uk -> true
     * - very.common@example.com -> true
     * - firstname.lastname@domain.com -> true
     * - "email"@example.org -> true
     * - 1234567890@example.com -> true
     * - admin@mail-server.com -> true
     * - user@sub.domain.com -> true
     * - user@[IPv6:2001:db8::1] -> true  (буквальный IPv6-адрес)
     * граничные вернут  -> false:
     * - user@ – отсутствует домен
     * - user@domain – отсутствует точка в доменной части (нужно как минимум domain.com)
     * - user@.com – отсутствует имя домена перед точкой
     * - user@domain. – точка в конце домена
     * - user..name@domain.com – две точки подряд в локальной части
     * - .user@domain.com – локальная часть начинается с точки
     * - user@domain..com – две точки подряд в домене
     * - user name@domain.com – пробел в адресе (недопустим без кавычек)
     * - user@domain.c – доменная зона слишком короткая (один символ)
     * - user@-domain.com – домен начинается с дефиса
     * - user@domain-.com – домен заканчивается дефисом
     * - user@domain.c o m – пробел внутри домена
     * - user@domain,com – запятая вместо точки
     * - user@domain..com – повторяющаяся точка
     * - user@ (пустая строка после @)
     * - user – отсутствует символ @ и домен
     * - null
     */


    @ParameterizedTest
    @ValueSource(strings = {
            "simple@example.com",
            "user.name+tag@domain.co.uk",
            "very.common@example.com",
            "firstname.lastname@domain.com",
            "\"email\"@example.org",
            "1234567890@example.com",
            "admin@mail-server.com",
            "user@sub.domain.com",
            "user@[IPv6:2001:db8::1]"
    })
    void checkIfValidEmail(String email) {
        assertTrue(new Task6().isValidEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "user@",
            "user@domain",
            "user@.com",
            "user@domain.",
            "user..name@domain.com",
            ".user@domain.com",
            "user@domain..com",
            "user name@domain.com",
            "user@domain.c",
            "user@-domain.com",
            "user@domain-.com",
            "user@domain.c o m",
            "user@domain,com",
            "user@domain..com",
            "user@",
            "user"
    })
    void checkIfInvalidEmail(String email) {
        assertFalse(new Task6().isValidEmail(email));
    }

    @Test
    void checkIfNullEmail() {
        assertFalse(new Task6().isValidEmail(null));
    }
}
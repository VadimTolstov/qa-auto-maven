package ru.tolstov.hw12.userValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
    }

    /**
     * #	Имя (name)	Возраст (age)	Email (email)	            Валидация включена	Ожидаемый результат
     * проверка имени/ возраста/ почты
     * 1	"Анна"	    25	            "anna@mail.ru"	                    true	        Успех (без исключения)
     * 2	"А"	        25	            "anna@mail.ru"	                    true	        Успех (без исключения)
     * 3	"Sem"	    18	            "user@domain.com"	                true	        Успех
     * 4	"Виктор"	66	            "user@domain.com"	                true	        Успех
     * 4	"Анна"	    66	            "test@example.com"	                true	        Успех
     * 4	"Анна"	    66	            ""user s"@domain.com"	            true	        Успех
     * 4	"Анна"	    66	            "simple@example.com"                true	        Успех
     * 4	"Анна"	    66	            "user.name+tag@domain.co.uk"        true	        Успех
     * 4	"Анна"	    66	            "very.common@example.com"           true	        Успех
     * 4	"Анна"	    66	            "irstname.lastname@domain.com"      true	        Успех
     * 4	"Анна"	    66	            "1234567890@example.com"            true	        Успех
     * 4	"Анна"	    66	            "user@[IPv6:2001:db8::1]"           true	        Успех
     * 4	"Анна"	    66	            "user@sub.domain.com"               true	        Успех
     * 8	"Анна"	    100	            "user@domain.com"	                true	        Успех
     * 12	"Анна"	    25	            "user@domain"	                    true	        Успех
     * проверка валидации имени
     * 2	null	    30	            "user@domain.com"	                true	        InvalidUserException
     * 3	""	        30	            "user@domain.com"	                true	        InvalidUserException
     * 4	" " 	    30	            "user@domain.com"	                true	        InvalidUserException
     * 5	"анна"	    30	            "user@domain.com"	                true	        InvalidUserException
     * 5	"а"	        30	            "user@domain.com"	                true	        InvalidUserException
     * проверка валидации возраста
     * 6	"Анна"	    17	            "user@domain.com"	                true	        InvalidUserException
     * 6	"Анна"	    0	            "user@domain.com"	                true	        InvalidUserException
     * 6	"Анна"	   -100	            "user@domain.com"	                true	        InvalidUserException
     * 9	"Анна"	    101	            "user@domain.com"	                true	        InvalidUserException
     * 9	"Анна"	    200	            "user@domain.com"	                true	        InvalidUserException
     * проверка валидации почты
     * 10	"Анна"	    25	            null	                            true	        InvalidUserException
     * 10	"Анна"	    25	            ""  	                            true	        InvalidUserException
     * 11	"Анна"	    25	            "not_email"	                        true	        InvalidUserException
     * 12	"Анна"	    25	            "user@.domain"	                    true	        InvalidUserException
     * 12	"Анна"	    25	            ""user@.domain""	                true	        InvalidUserException
     * проверка отключения флага валидации
     * 13	null	    500	            null	                            false	        Успех (без исключения)
     * 14	"Анна"	    18	            "user@domain.com"                   false	        Успех (без исключения)
     */
    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(new User("Анна", 25, "anna@mail.ru")),
                Arguments.of(new User("А", 25, "anna@mail.ru")),
                Arguments.of(new User("Sem", 18, "user@domain.com")),
                Arguments.of(new User("Виктор", 66, "user@domain.com")),
                Arguments.of(new User("Анна", 66, "test@example.com")),
                Arguments.of(new User("Анна", 66, "\"user s\"@domain.com")),
                Arguments.of(new User("Анна", 66, "simple@example.com")),
                Arguments.of(new User("Анна", 66, "user.name+tag@domain.co.uk")),
                Arguments.of(new User("Анна", 66, "very.common@example.com")),
                Arguments.of(new User("Анна", 66, "irstname.lastname@domain.com")),
                Arguments.of(new User("Анна", 66, "1234567890@example.com")),
                Arguments.of(new User("Анна", 66, "user@[IPv6:2001:db8::1]")),
                Arguments.of(new User("Анна", 66, "user@sub.domain.com")),
                Arguments.of(new User("Анна", 100, "user@domain.com")),
                Arguments.of(new User("Анна", 25, "user@domain"))

        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkValidUser(User user) {
        userValidator.setValidationEnabled(true);
        assertDoesNotThrow(() -> userValidator.isValidUser(user));
    }

    public static Stream<Arguments> dataForInvalidUserNameCases() {
        return Stream.of(
                Arguments.of(new User(null, 30, "user@domain.com")),
                Arguments.of(new User("", 30, "user@domain.com")),
                Arguments.of(new User(" ", 30, "user@domain.com")),
                Arguments.of(new User("анна", 30, "user@domain.com")),
                Arguments.of(new User("а", 30, "user@domain.com"))


        );
    }

    @ParameterizedTest
    @MethodSource("dataForInvalidUserNameCases")
    void checkInvalidUserName(User user) {
        userValidator.setValidationEnabled(true);
        InvalidUserException invalidUserException = assertThrows(
                InvalidUserException.class,
                () -> userValidator.isValidUser(user)
        );
        assertEquals("Имя пользователя: " + user.getName() + " не прошло валидацию", invalidUserException.getMessage());
    }

    public static Stream<Arguments> dataForInvalidUserAgeCases() {
        return Stream.of(
                Arguments.of(new User("Анна", 17, "user@domain.com")),
                Arguments.of(new User("Анна", 0, "user@domain.com")),
                Arguments.of(new User("Анна", -100, "user@domain.com")),
                Arguments.of(new User("Анна", 101, "user@domain.com")),
                Arguments.of(new User("Анна", 200, "user@domain.com"))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForInvalidUserAgeCases")
    void checkInvalidUserAge(User user) {
        userValidator.setValidationEnabled(true);
        InvalidUserException invalidUserException = assertThrows(
                InvalidUserException.class,
                () -> userValidator.isValidUser(user)
        );
        assertEquals("Возраст пользователя: " + user.getAge() + " не прошел валидацию", invalidUserException.getMessage());
    }

    public static Stream<Arguments> dataForInvalidUserEmailCases() {
        return Stream.of(
                Arguments.of(new User("Анна", 25, null)),
                Arguments.of(new User("Анна", 25, "")),
                Arguments.of(new User("Анна", 25, "not_email")),
                Arguments.of(new User("Анна", 25, "user@.domain")),
                Arguments.of(new User("Анна", 25, "\"user@.domain\""))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForInvalidUserEmailCases")
    void checkInvalidUserEmail(User user) {
        userValidator.setValidationEnabled(true);
        InvalidUserException invalidUserException = assertThrows(
                InvalidUserException.class,
                () -> userValidator.isValidUser(user)
        );
        assertEquals("Email пользователя: " + user.getEmail() + " не прошел валидацию", invalidUserException.getMessage());
    }

    public static Stream<Arguments> dataForVenInvalidUserFlagFalseCases() {
        return Stream.of(
                Arguments.of(new User(null, 500, null)),
                Arguments.of(new User("Анна", 18, "user@domain.com"))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForVenInvalidUserFlagFalseCases")
    void checkVenInvalidUserFlagFalse(User user) {
        assertDoesNotThrow(() -> userValidator.isValidUser(user));
    }

    @Test
    void checkExceptionIfArgumentNull() {
        userValidator.setValidationEnabled(true);
        InvalidUserException invalidUserException = assertThrows(
                InvalidUserException.class,
                () -> userValidator.isValidUser(null));
        assertEquals("Пользователь не должен быть null", invalidUserException.getMessage());
    }
}
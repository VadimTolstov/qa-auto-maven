package ru.tolstov.hw12.userValidator;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

import java.util.regex.Pattern;

public class UserValidator {

    private boolean invalidUserException;

    public boolean isInvalidUserException() {
        return invalidUserException;
    }

    public void setInvalidUserException(boolean invalidUserException) {
        this.invalidUserException = invalidUserException;
    }

    public void isValidUser(User user) {
        if (invalidUserException) {
            if (user == null) {
                throw new InvalidUserException("Пользователь не должен быть null");
            }
            isValidName(user.getName());
            isValidAge(user.getAge());
            isValidEmail(user.getEmail());
        }
    }

    private void isValidName(String name) {
        if (name == null || name.isBlank() || !Pattern.compile("\\p{Lu}.*").matcher(name).matches()) {
            throw new InvalidUserException("Имя пользователя: " + name + " не прошло валидацию");
        }
    }

    private void isValidAge(int age) {
        if (age < 18 || age > 100) {
            throw new InvalidUserException("Возраст пользователя: " + age + " не прошел валидацию");
        }
    }

    private void isValidEmail(String email) {
        if (email == null) {
            throw new InvalidUserException("Email пользователя: " + email + " не прошел валидацию");
        }
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            throw new InvalidUserException("Email пользователя: " + email + " не прошел валидацию");
        }
    }
}

package ru.tolstov.hw10;

public class Task10 {
    public boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\+\\d{1,3} \\d{10}");
    }

}

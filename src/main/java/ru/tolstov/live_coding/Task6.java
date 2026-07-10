package ru.tolstov.live_coding;

public class Task6 {
    public int fact(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал для отрицательных чисел");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}

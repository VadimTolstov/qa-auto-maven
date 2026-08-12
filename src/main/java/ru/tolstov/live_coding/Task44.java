package ru.tolstov.live_coding;

public class Task44 {
    public static int factorial(int number) {
        int count = 1;
        for (int i = 1; i <= number; i++) {
            count = count * i;
        }
        return count;
    }

    public static int factorial2(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial2(number - 1);
    }
}

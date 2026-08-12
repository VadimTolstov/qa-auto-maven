package ru.tolstov.clean.code.hw1.task1;

import java.util.Arrays;

public class MathOperations {
    public int addNumbers(int... numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        MathOperations mathOperations = new MathOperations();
        System.out.println(mathOperations.addNumbers(1, 2, 3));
        System.out.println(mathOperations.addNumbers(1));
    }
}
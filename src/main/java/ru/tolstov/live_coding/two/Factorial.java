package ru.tolstov.live_coding.two;

public class Factorial {

    public static int factorial(int j) {
        int result = 1;
        for (int i = 2; i <= j; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
    }
}

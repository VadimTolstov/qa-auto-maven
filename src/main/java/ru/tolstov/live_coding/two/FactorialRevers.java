package ru.tolstov.live_coding.two;

import java.util.*;

public class FactorialRevers {
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }

    public static void main(String[] args) {
        System.out.println(factorial(-10));
    }
}

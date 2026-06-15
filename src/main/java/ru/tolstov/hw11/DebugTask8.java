package ru.tolstov.hw11;

/**
 * Код должен сравнить два числа, но почему-то результат не соответствует ожиданиям.
 */
public class DebugTask8 {
    public static void main(String[] args) {
        double a = 0.1 * 3;
        double b = 0.3;
        if (Math.abs(a - b) < 1e-9) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}

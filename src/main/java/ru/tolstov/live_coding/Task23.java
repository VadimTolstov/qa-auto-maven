package ru.tolstov.live_coding;

/**
 * Ноль — чётное число.
 * Отрицательные числа могут быть четными.
 */
public class Task23 {
    public static boolean isEvent(int i) {
        return i % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEvent(-5));
        System.out.println(isEvent(-4));
        System.out.println(isEvent(4));
        System.out.println(isEvent(0));
    }
}

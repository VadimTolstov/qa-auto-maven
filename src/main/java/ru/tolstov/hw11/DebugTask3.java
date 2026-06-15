package ru.tolstov.hw11;

/**
 * Код должен напечатать числа от 1 до 5, но программа зависает.
 */
public class DebugTask3 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println("Number: " + i);
            i++;
        }
    }
}
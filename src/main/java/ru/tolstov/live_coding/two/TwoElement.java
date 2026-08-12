package ru.tolstov.live_coding.two;

import java.util.Arrays;
import java.util.Comparator;

public class TwoElement {
    public static int twoElement(int[] array) {
        int first = array[0];
        int second = array[0];

        for (int j : array) {
            if (first < j) {
                second = first;
                first = j;
            }
        }
        return second;
    }

    public static int twoElement2(int[] array) {
        return Arrays.stream(array).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(twoElement2(new int[]{2,2}));
    }

}

package ru.tolstov.live_coding;

/**
 * Поиск максимальной суммы от количества заданных элементов по порядку в неотсортированном массиве.
 */

import java.util.Arrays;

public class Window {
    public static int sumArrayIndex(int[] array, int k) {
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int elementNumber = i + k - 1;
            if (elementNumber < array.length) {
                int actualSum = Arrays.stream(array).limit(i + k).skip(i).sum();
                sum = Math.max(sum, actualSum);
            }
        }
        return sum;
    }

    public static int maxSumOfKElements(int[] array, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += array[i];
        }
        int sum = windowSum;
        for (int i = k; i < array.length; i++) {
            windowSum = windowSum + array[i] - array[i - k];
            if (sum < windowSum) {
                sum = windowSum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 3, 4, 5, 6};
        int[] arrays2 = new int[]{6, 5, 4, 3, 2, 1};
        int[] arrays3 = new int[]{1, 4, 5, 6, 3, 2};
        System.out.println(sumArrayIndex(arrays, 3));
        System.out.println(sumArrayIndex(arrays2, 3));
        System.out.println(sumArrayIndex(arrays3, 3));
        System.out.println(sumArrayIndex(arrays3, 2));
        System.out.println(sumArrayIndex(arrays3, 4));
//        System.out.println(maxSumOfKElements(arrays, 3));
//        System.out.println(maxSumOfKElements(arrays2, 3));
//        System.out.println(maxSumOfKElements(arrays3, 3));
//        System.out.println(maxSumOfKElements(arrays3, 2));
//        System.out.println(maxSumOfKElements(arrays3, 4));
    }
}
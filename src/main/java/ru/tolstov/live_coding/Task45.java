package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task45 {
    public static int[] swap(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int element = array[right];
            array[right--] = array[left];
            array[left++] = element;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(swap(new int[]{1, 2, 3, 4, 5, 6, 7})));
        System.out.println(Arrays.toString(swap(new int[]{1, 2, 3, 4, 5, 6,})));
    }
}

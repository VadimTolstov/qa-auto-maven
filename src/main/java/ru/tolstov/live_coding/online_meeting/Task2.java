package ru.tolstov.live_coding.online_meeting;

import java.util.Arrays;

/**
 * масив -> надо его развернуть
 * [1,2,3,4] -> [4,3,2,1]
 * [2,3,5,6,7] -> [7,6,5,3,2]
 */

public class Task2 {
    public static void reversArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int element = array[left];
            array[left++] = array[right];
            array[right--] = element;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{2,3,5,6,7};
        reversArray(array);
        reversArray(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}

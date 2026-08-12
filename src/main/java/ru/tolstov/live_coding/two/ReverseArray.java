package ru.tolstov.live_coding.two;

public class ReverseArray {
    private int[] reverseArray(int[] array) {
        int right = array.length - 1;
        int left = 0;
        while (left < right) {
            int element = array[left];
            array[left++] = array[right];
            array[right--] = element;
        }
        return array;
    }
}

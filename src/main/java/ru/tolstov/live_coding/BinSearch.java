package ru.tolstov.live_coding;

public class BinSearch {
    static int[] array1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static int binSearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binSearch(array1, 9));
    }
}

package ru.tolstov.live_coding.two;

public class MergeSortedArrays {


    private static int[] mergeSortedArrays(int[] a, int[] b) {
        int indexA = 0;
        int indexB = 0;
        int[] result = new int[a.length + b.length];
        int i = 0;
        while (indexA < a.length && indexB < b.length) {
            result[i++] = a[indexA] > b[indexB] ? a[indexA++] : b[indexB++];
        }
        while (indexA < a.length) {
            result[i++] = a[indexA++];
        }
        while (indexB < b.length) {
            result[i++] = b[indexB++];
        }
        return result;
    }
}

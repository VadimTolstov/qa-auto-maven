package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task39 {
    public static int[] testInt(int[] arrayA, int[] arrayB) {
        return IntStream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB))
                .sorted()
                .toArray();
    }

    public static String[] testString(String[] arrayA, String[] arrayB) {
        return Stream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB))
                .sorted()
                .toArray(String[]::new);
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    public static void main(String[] args) {
        // ---------- Тесты для int[] ----------
        System.out.println("=== Тесты для int[] ===");
//        System.out.println(Arrays.toString(testInt(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8})));
//        System.out.println(Arrays.toString(testInt(new int[]{10, 20, 30}, new int[]{5, 15, 25, 35, 45})));
//        System.out.println(Arrays.toString(testInt(new int[]{1, 2, 2, 3}, new int[]{2, 3, 3, 4})));
//        System.out.println(Arrays.toString(testInt(new int[]{4, 5, 6}, new int[]{})));
//        System.out.println(Arrays.toString(testInt(new int[]{}, new int[]{})));
//        System.out.println(Arrays.toString(testInt(new int[]{-5, -3, 0}, new int[]{-4, -2, 1, 2})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{10, 20, 30}, new int[]{5, 15, 25, 35, 45})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 2, 2, 3}, new int[]{2, 3, 3, 4})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 2, 2, 3,7,8,9}, new int[]{2, 3, 3, 4})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{4, 5, 6}, new int[]{})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{}, new int[]{})));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{-5, -3, 0}, new int[]{-4, -2, 1, 2})));

        // ---------- Тесты для String[] ----------
        System.out.println("\n=== Тесты для String[] ===");
        System.out.println(Arrays.toString(testString(new String[]{"apple", "banana", "cherry"},
                new String[]{"apricot", "blueberry", "date"})));
        System.out.println(Arrays.toString(testString(new String[]{"dog", "elephant"},
                new String[]{"cat", "fish", "zebra"})));
        System.out.println(Arrays.toString(testString(new String[]{"a", "b", "b", "c"},
                new String[]{"b", "c", "c", "d"})));
        System.out.println(Arrays.toString(testString(new String[]{"Apple", "banana"},
                new String[]{"apricot", "Banana"})));
        System.out.println(Arrays.toString(testString(new String[]{"x", "y", "z"}, new String[]{})));
    }
}

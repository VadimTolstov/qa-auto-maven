package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task36 {


    public static int[] twoSum(int[] array, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(array[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 7, 6, 8, 10, 11, 5}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 7, 6, 8, 10, 11, 5}, 21)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 7, 6, 8, 10, 11, 5}, 8)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 7, 7, 6, 8, 10, 11, 5}, 14)));
    }
}
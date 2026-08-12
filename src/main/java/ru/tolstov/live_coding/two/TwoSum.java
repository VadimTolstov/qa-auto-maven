package ru.tolstov.live_coding.two;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{i, map.get(target - array[i])};
            }
            map.put(array[i], i);
        }
        return new int[0];
    }
}
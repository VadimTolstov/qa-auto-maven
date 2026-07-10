package ru.tolstov.live_coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task12 {
    public static boolean allUnique(int[] array) {
        Objects.requireNonNull(array);
        long arrayLang = array.length;
        long count = Arrays.stream(array).distinct().count();
        return arrayLang == count;
    }
    public static boolean allUnique2(int[] array) {
        Objects.requireNonNull(array);
        Set<Integer> set = new HashSet<>();
        for (int element : array){
            if (!set.add(element)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(allUnique(new int[]{1, 2, 3}));
        int[] arrays = new int[10];
        arrays[0] = 1;
        arrays[9] = 8;
        System.out.println(allUnique(arrays));
    }

}

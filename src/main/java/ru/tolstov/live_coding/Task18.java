package ru.tolstov.live_coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task18 {
    public static boolean contains(List<Integer> list, int number) {
        Objects.requireNonNull(list);
        return list.contains(number);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(5);
        System.out.println(contains(list,5));
    }
}

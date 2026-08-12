package ru.tolstov.oop.zd14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Song {

    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        list.add(4);
        list.addAll(List.of(1, 2, 3));
       // list.sort(Integer::compareTo);
        list.stream().sorted().forEach(System.out::println);
        //System.out.println(list);
    }
}



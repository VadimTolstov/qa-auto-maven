package ru.tolstov.live_coding;

import java.util.HashSet;
import java.util.Set;

public class Task34 {
    public static int uniqueCars(String s) {
        Set<Character> characters = new HashSet<>();
        for (Character c : s.toLowerCase().trim().toCharArray()) {
            characters.add(c);
        }
        return characters.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueCars("Привет"));
        System.out.println(uniqueCars("Как"));
        System.out.println(uniqueCars("ТыТы"));
    }
}

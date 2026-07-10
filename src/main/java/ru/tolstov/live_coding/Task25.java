package ru.tolstov.live_coding;

import java.util.Objects;

public class Task25 {
    public static String join(String[] strings) {
        Objects.requireNonNull(strings);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(join(new String[]{"Привет", "Как дела", "Пойдем гулять"}));
        System.out.println(join(new String[]{"Привет", " ", "Пойдем гулять"}));
    }
}

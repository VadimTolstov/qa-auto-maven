package ru.tolstov.live_coding;

import java.util.Random;

public class Task33 {
    public static int getRandom() {
        return new Random().nextInt(10) + 1;
    }

    public static void main(String[] args) {
        System.out.println(getRandom());
    }
}

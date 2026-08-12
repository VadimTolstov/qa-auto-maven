package ru.tolstov.live_coding;

import java.text.DecimalFormat;

public class Task30 {
    public static void format(double number) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(number));
    }

    public static void main(String[] args) {
        format(1.333);
    }
}

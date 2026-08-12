package ru.tolstov.live_coding.two;

public class Format {

    public static void format(double d){
        System.out.printf("%.2f",d);
    }

    public static void main(String[] args) {
        format(20.115);
    }
}

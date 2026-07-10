package ru.tolstov.live_coding;

import java.math.BigInteger;

public class Task4 {
    public static boolean isPrime(int n) {
        return BigInteger.valueOf(n).isProbablePrime(10);
    }

    public static boolean isPrime2(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(0));
        System.out.println(isPrime(1));
        System.out.println(isPrime(10));
        System.out.println(isPrime(-1));
        System.out.println(isPrime(3));
        System.out.println(isPrime(3));
        System.out.println(isPrime(3));
    }
}
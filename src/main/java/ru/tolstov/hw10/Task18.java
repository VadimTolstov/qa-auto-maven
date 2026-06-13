package ru.tolstov.hw10;

public class Task18 {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

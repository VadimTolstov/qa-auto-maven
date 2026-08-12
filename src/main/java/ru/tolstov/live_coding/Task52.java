package ru.tolstov.live_coding;

import java.util.Arrays;

public class Task52 {
    public int[] countEvenOdd(int[] array) {
        int[] result = new int[2];
        result[0] = (int) Arrays.stream(array).filter(e -> e % 2 == 0).count();
        result[1] = (int) Arrays.stream(array).filter(e -> e % 2 != 0).count();
        return result;
    }

    public int[] countEvenOdd2(int[] array) {
        int[] result = new int[2];
        Arrays.stream(array).forEach(e -> result[(e % 2 == 0 ? 0 : 1)]++);
        return result;
    }

    public int[] countEvenOdd3(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
        int even = 0, odd = 0;
        for (int e : array) {
            if (e % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[]{even, odd};
    }
}

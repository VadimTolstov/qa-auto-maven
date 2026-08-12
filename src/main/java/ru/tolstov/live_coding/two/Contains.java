package ru.tolstov.live_coding.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contains {

    public boolean isContains(int[] array) {
        List<Integer> list = new ArrayList<>(Arrays.stream(array).boxed().toList());
        return list.contains(1);
    }
}

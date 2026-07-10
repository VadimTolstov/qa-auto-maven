package ru.tolstov.live_coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task21 {
    public static List<String> merge(List<String> a, List<String> b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
        List<String> list = new ArrayList<>(a);
        list.addAll(b);
        return list;
    }
}

package ru.tolstov.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Код должен удалять элементы списка, но выбрасывает ConcurrentModificationException.
 */
public class DebugTask10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        for (int i = names.size() - 1 ; i >= 0 ; i--) {
            if (names.get(i).startsWith("A")) {
                names.remove(i);
            }
        }
    }
}

package ru.tolstov.live_coding;

import java.util.*;

public class Task27 {
    public static void print(Queue<String> queue) {
        Objects.requireNonNull(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("Один");
        queue.offer("Два");
        queue.offer("Три");
       print(queue);
    }
}

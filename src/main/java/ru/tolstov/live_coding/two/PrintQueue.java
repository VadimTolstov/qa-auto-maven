package ru.tolstov.live_coding.two;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintQueue {
    public static void printQueue(Queue<String> stringQueue) {
        while (!stringQueue.isEmpty()){
            System.out.println(stringQueue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("Раз");
        queue.offer("Два");
        queue.offer("Три");

        printQueue(queue);
    }
}

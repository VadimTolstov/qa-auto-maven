package ru.tolstov.live_coding.two;

import java.util.Stack;

public class Balanced {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.replaceAll("\\s+", "").toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            switch (c) {
                case '{', '(', '[' -> stack.push(c);
                case '}' -> {
                    if ('{' == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                case ']' -> {
                    if ('[' == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                case ')' -> {
                    if ('(' == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{ { } ( ) } ( )"));
        System.out.println(isBalanced(")  { { } } ( )"));
        System.out.println(isBalanced(") ( { { } } ( )"));
    }
}

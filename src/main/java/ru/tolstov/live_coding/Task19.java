package ru.tolstov.live_coding;

import java.util.Objects;
import java.util.Stack;

public class Task19 {
    public static boolean isBalanced(String str) {
        Objects.requireNonNull(str);
        Stack<String> stringStack = new Stack<>();
        for (String s : str.trim().split(" ")) {
            if (stringStack.empty()) {
                stringStack.push(s);
                continue;
            }
            switch (s) {
                case "{", "[", "(" -> stringStack.push(s);
                case "}" -> {
                    if ("{".equals(stringStack.peek())) {
                        stringStack.pop();
                    } else {
                        stringStack.push(s);
                    }
                }
                case "]" -> {
                    if ("[".equals(stringStack.peek())) {
                        stringStack.pop();
                    } else {
                        stringStack.push(s);
                    }
                }
                case ")" -> {
                    if ("(".equals(stringStack.peek())) {
                        stringStack.pop();
                    } else {
                        stringStack.push(s);
                    }
                }
            }
        }
        return stringStack.empty();
    }

    public static boolean isBalanced2(String str) {
        Objects.requireNonNull(str);
        Stack<Character> stringStack = new Stack<>();
        for (char s : str.toCharArray()) {
            if (stringStack.empty()) {
                if (s == '(' || s == ')') {
                    stringStack.push(s);
                    continue;
                }
            }
            switch (s) {
                case '(' -> stringStack.push(s);
                case ')' -> {
                    if ('(' == stringStack.peek()) {
                        stringStack.pop();
                    } else {
                        stringStack.push(s);
                    }
                }
            }
        }
        return stringStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{ { } ( ) } ( )"));
        System.out.println(isBalanced(")  { { } } ( )"));
        System.out.println(isBalanced(") ( { { } } ( )"));

        System.out.println(isBalanced2("Привет как дела ()"));
        System.out.println(isBalanced2("Привет как дела ()("));
        System.out.println(isBalanced2("(Привет как дела ())"));

    }
}

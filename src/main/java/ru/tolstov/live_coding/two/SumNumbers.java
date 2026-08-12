package ru.tolstov.live_coding.two;

public class SumNumbers {
    private static int sumNumbers(String str) {
        String[] arrayString = str
                .replaceAll(",", " ")
                .replaceAll("[^0-9 -]", "")
                .replaceAll("\\s+", " ")
                .trim()
                .split("\\s+");
        int sum = 0;
        for (String s : arrayString) {
            try {
                sum += Integer.parseInt(s);
            } catch (NumberFormatException ignored) {
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers("123,345,dfs  344 443"));
        System.out.println(sumNumbers("-1 "));
    }
}

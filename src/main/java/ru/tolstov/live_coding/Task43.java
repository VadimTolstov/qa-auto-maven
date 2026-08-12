package ru.tolstov.live_coding;

public class Task43 {
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiou";
        for (char c : str.toLowerCase().trim().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int countVowels2(String str) {
        return str.replaceAll("[^aeiou]", "").length();

    }

    public static void main(String[] args) {
        System.out.println(countVowels("abs "));
        System.out.println(countVowels2("abs "));
        System.out.println(countVowels(" cbs "));
        System.out.println(countVowels2(" cbs "));
    }
}

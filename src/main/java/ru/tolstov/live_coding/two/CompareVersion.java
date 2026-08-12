package ru.tolstov.live_coding.two;

public class CompareVersion {

    private boolean compare(String str1, String str2) {
        String[] strings1 = str1.split("\\.");
        String[] strings2 = str2.split("\\.");
        boolean isCompare = true;
        for (int i = 0; i < Math.max(strings1.length, strings2.length); i++) {
            int n1 = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int n2 = i < strings2.length ? Integer.parseInt(strings2[i]) : 0;
            if (n1 != n2) {
                isCompare = false;
            }
        }
        return isCompare;
    }
}

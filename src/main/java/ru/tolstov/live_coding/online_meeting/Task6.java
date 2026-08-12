package ru.tolstov.live_coding.online_meeting;

//реализовать стартВиф без методов
//Вадим Ва ->true
//Ва  Ва -> true
public class Task6 {

    private static boolean starWiz(String str, String pref) {
        if (str.length() < pref.length()) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < pref.length(); i++) {
            if (str.charAt(i) == pref.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(starWiz("Вадим", "Ва"));
        System.out.println(starWiz("Олег", "Олег"));
        System.out.println(starWiz("Сер", "Се"));
        System.out.println(starWiz("Сер", "Ве"));
        System.out.println(starWiz("С", "Ве"));
    }
}

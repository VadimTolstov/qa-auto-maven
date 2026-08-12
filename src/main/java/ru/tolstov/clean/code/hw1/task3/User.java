package ru.tolstov.clean.code.hw1.task3;

/*
из-за отсутствия гетеров в классе User он выглядит как будто его вообще не используют,
но может данные из полей получают и добовляют через рефлексию.
по этому могу удалить только одно поле - private String socialSecurityNumber; // Никогда не используется
 */
public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isPremiumMember;
    private int rewardPoints;
    private String preferredLanguage;
    private String homeAddress;
    private String workAddress;
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

package ru.tolstov.clean.code.hw2.creational.builder.task2;


public class Main {
    public static void main(String[] args) {
        Personage person =  new Personage
                .PersonageBuilder()
                .setArmor(100)
                .setDamage(20)
                .setMagic(500)
                .setHealth(200)
                .build();

        System.out.println(person);
    }
}

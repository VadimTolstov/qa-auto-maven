package ru.tolstov.oop.zd3;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(getName() + " ест мясо");
    }

    @Override
    void sleep() {
        System.out.println(getName() + " спит в будке");
    }
}

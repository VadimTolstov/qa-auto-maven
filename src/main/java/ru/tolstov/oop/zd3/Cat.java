package ru.tolstov.oop.zd3;

public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(getName() + " ест рыбу");
    }

    @Override
    void sleep() {
        System.out.println(getName() + " спит на подоконнике");
    }
}

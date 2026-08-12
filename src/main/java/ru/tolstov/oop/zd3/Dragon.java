package ru.tolstov.oop.zd3;

public class Dragon extends Pet {

    public Dragon(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(getName() + " ест уголь");
    }

    @Override
    void sleep() {
        System.out.println(getName() + " спит в пещере");
    }
}

package ru.tolstov.oop.zd3;

public abstract class Pet {
    private final String name;

    public Pet(String name) {
        this.name = name;
    }

    abstract void eat();
    abstract void sleep();

    public String getName() {
        return name;
    }
}

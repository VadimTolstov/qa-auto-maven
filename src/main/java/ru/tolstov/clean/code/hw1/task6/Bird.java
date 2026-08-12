package ru.tolstov.clean.code.hw1.task6;

abstract class Bird {
}

class FlyingBird extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Птица летит");
    }
}

class Penguin extends Bird {
}

interface Flyable {
    void fly();
}

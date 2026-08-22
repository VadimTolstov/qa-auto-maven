package ru.tolstov.clean.code.hw2.creational.factory.task1.classic;

import ru.tolstov.clean.code.hw2.creational.factory.task1.Chair;

public class ClassicChair implements Chair {

    @Override
    public void sit() {
        System.out.println("Classic chair");
    }
}

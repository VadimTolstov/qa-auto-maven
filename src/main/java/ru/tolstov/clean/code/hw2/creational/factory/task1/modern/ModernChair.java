package ru.tolstov.clean.code.hw2.creational.factory.task1.modern;

import ru.tolstov.clean.code.hw2.creational.factory.task1.Chair;

public class ModernChair implements Chair {

    @Override
    public void sit() {
        System.out.println("Modern chair");
    }
}

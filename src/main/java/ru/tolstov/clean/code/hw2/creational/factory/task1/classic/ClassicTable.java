package ru.tolstov.clean.code.hw2.creational.factory.task1.classic;

import ru.tolstov.clean.code.hw2.creational.factory.task1.Table;

public class ClassicTable implements Table {

    @Override
    public void use() {
        System.out.println("Classic table used");
    }
}

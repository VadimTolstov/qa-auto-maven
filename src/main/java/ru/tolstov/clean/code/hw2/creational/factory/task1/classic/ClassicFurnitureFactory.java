package ru.tolstov.clean.code.hw2.creational.factory.task1.classic;

import ru.tolstov.clean.code.hw2.creational.factory.task1.Chair;
import ru.tolstov.clean.code.hw2.creational.factory.task1.FurnitureFactory;
import ru.tolstov.clean.code.hw2.creational.factory.task1.Table;

public class ClassicFurnitureFactory implements FurnitureFactory {
    @Override
    public Table createTable() {
        return new ClassicTable();
    }

    @Override
    public Chair createChair() {
        return new ClassicChair();
    }
}

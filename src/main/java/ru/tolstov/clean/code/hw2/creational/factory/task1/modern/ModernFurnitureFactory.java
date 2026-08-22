package ru.tolstov.clean.code.hw2.creational.factory.task1.modern;

import ru.tolstov.clean.code.hw2.creational.factory.task1.Chair;
import ru.tolstov.clean.code.hw2.creational.factory.task1.FurnitureFactory;
import ru.tolstov.clean.code.hw2.creational.factory.task1.Table;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}

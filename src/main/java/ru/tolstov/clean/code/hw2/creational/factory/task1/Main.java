package ru.tolstov.clean.code.hw2.creational.factory.task1;

import ru.tolstov.clean.code.hw2.creational.factory.task1.classic.ClassicFurnitureFactory;
import ru.tolstov.clean.code.hw2.creational.factory.task1.modern.ModernFurnitureFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactoryProvider.registerFactory(FurnitureStyle.CLASSIC, ClassicFurnitureFactory::new);
        FurnitureFactoryProvider.registerFactory(FurnitureStyle.MODERN, ModernFurnitureFactory::new);
        FurnitureFactory factory = FurnitureFactoryProvider.getFactory(FurnitureStyle.CLASSIC);
        Chair chair = factory.createChair();
        Table table = factory.createTable();
        chair.sit();
        table.use();

        factory = FurnitureFactoryProvider.getFactory(FurnitureStyle.MODERN);
        chair = factory.createChair();
        table = factory.createTable();
        chair.sit();
        table.use();
    }
}

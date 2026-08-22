package ru.tolstov.clean.code.hw2.creational.factory.task2.mac;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Menu;
import ru.tolstov.clean.code.hw2.creational.factory.task2.Window;

public class MacMenu implements Menu {


    @Override
    public void openMenu() {
        System.out.println("MacMenu open");
    }
}

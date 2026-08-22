package ru.tolstov.clean.code.hw2.creational.factory.task2.mac;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Button;
import ru.tolstov.clean.code.hw2.creational.factory.task2.GUIFactory;
import ru.tolstov.clean.code.hw2.creational.factory.task2.Menu;
import ru.tolstov.clean.code.hw2.creational.factory.task2.Window;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButten();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }

    @Override
    public Window createWindow() {
        return new MacWindow();
    }
}

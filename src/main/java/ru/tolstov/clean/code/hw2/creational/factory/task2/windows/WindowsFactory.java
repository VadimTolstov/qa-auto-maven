package ru.tolstov.clean.code.hw2.creational.factory.task2.windows;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Button;
import ru.tolstov.clean.code.hw2.creational.factory.task2.GUIFactory;
import ru.tolstov.clean.code.hw2.creational.factory.task2.Menu;
import ru.tolstov.clean.code.hw2.creational.factory.task2.Window;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButten();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }
}

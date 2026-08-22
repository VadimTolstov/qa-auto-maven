package ru.tolstov.clean.code.hw2.creational.factory.task2;

import ru.tolstov.clean.code.hw2.creational.factory.task2.mac.MacFactory;
import ru.tolstov.clean.code.hw2.creational.factory.task2.windows.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        GIUFactoryProvider.registerFactory(GUIType.MAC, MacFactory::new);
        GIUFactoryProvider.registerFactory(GUIType.WINDOWS, WindowsFactory::new);

        Button button = GIUFactoryProvider.getFactory(GUIType.WINDOWS).createButton();
        Menu menu = GIUFactoryProvider.getFactory(GUIType.WINDOWS).createMenu();
        Window window = GIUFactoryProvider.getFactory(GUIType.WINDOWS).createWindow();
        button.click();
        menu.openMenu();
        window.open();

        button = GIUFactoryProvider.getFactory(GUIType.MAC).createButton();
        menu = GIUFactoryProvider.getFactory(GUIType.MAC).createMenu();
        window = GIUFactoryProvider.getFactory(GUIType.MAC).createWindow();
        button.click();
        menu.openMenu();
        window.open();

    }
}

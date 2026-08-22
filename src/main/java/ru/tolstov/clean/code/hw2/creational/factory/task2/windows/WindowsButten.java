package ru.tolstov.clean.code.hw2.creational.factory.task2.windows;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Button;

public class WindowsButten implements Button {
    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }
}

package ru.tolstov.clean.code.hw2.creational.factory.task2.windows;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Window;

public class WindowsWindow implements Window {


    @Override
    public void open() {
      System.out.println("Windows Window opened");
    }
}

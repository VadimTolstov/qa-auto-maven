package ru.tolstov.clean.code.hw2.creational.factory.task2.mac;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Button;
import ru.tolstov.clean.code.hw2.creational.factory.task2.Window;

public class MacWindow implements Window {


    @Override
    public void open() {
      System.out.println("MacWindow opened");
    }
}

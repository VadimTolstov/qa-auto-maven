package ru.tolstov.clean.code.hw2.creational.factory.task2.mac;

import ru.tolstov.clean.code.hw2.creational.factory.task2.Button;

import java.awt.*;

public class MacButten implements Button {
    @Override
    public void click() {
        System.out.println("Mac button clicked");
    }
}

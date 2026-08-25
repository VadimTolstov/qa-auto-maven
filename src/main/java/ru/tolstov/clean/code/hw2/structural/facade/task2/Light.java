package ru.tolstov.clean.code.hw2.structural.facade.task2;

public class Light implements SmartDevice {
    private boolean isItOn;

    @Override
    public void switchOn() {
        isItOn = true;
    }

    @Override
    public void switchOff() {
        isItOn = false;
    }

    @Override
    public boolean isActive() {
        return isItOn;
    }
}

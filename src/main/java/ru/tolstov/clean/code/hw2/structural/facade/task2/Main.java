package ru.tolstov.clean.code.hw2.structural.facade.task2;

public class Main {
    public static void main(String[] args) {
        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(
                new AirConditioner(),
                new Light(),
                new SecuritySystem()
        );
        smartHomeFacade.statusDevices();
        smartHomeFacade.turnOnAllDevices();
        smartHomeFacade.statusDevices();
        smartHomeFacade.turnOffAllDevices();
        smartHomeFacade.statusDevices();
    }
}

package ru.tolstov.clean.code.hw2.structural.facade.task1;

public class Main {
    public static void main(String[] args) {
        DoorFacade dorFacade = new DoorFacade(new DoorLock(), new DoorOpen(), new DoorClose());

        dorFacade.openDoor();
        dorFacade.closeDoor();
        dorFacade.lockDoor();
    }
}

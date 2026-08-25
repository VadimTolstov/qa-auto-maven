package ru.tolstov.clean.code.hw2.structural.facade.task1;

public class DoorFacade {
    private final DoorLock doorLock;
    private final DoorOpen doorOpen;
    private final DoorClose doorClose;

    public DoorFacade(DoorLock doorLock, DoorOpen doorOpen, DoorClose doorClose) {
        this.doorLock = doorLock;
        this.doorOpen = doorOpen;
        this.doorClose = doorClose;
    }

    public void openDoor() {
        doorOpen.open();
    }

    public void closeDoor() {
        doorClose.close();
    }

    public void lockDoor() {
        doorLock.lock();
    }
}

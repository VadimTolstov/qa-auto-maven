package ru.tolstov.clean.code.hw2.structural.facade.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartHomeFacade {
    private final List<SmartDevice> smartDeviceList = new ArrayList<>();

    public SmartHomeFacade(SmartDevice... smartDevices) {
        smartDeviceList.addAll(Arrays.asList(smartDevices));
    }

    public void turnOnAllDevices() {
        smartDeviceList.forEach(SmartDevice::switchOn);
    }

    public void turnOffAllDevices() {
        smartDeviceList.forEach(SmartDevice::switchOff);
    }

    public void statusDevices() {
        smartDeviceList.forEach(d -> System.out.print(d.isActive() + " "));
        System.out.println();
    }
}

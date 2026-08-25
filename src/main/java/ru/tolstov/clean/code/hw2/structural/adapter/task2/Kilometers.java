package ru.tolstov.clean.code.hw2.structural.adapter.task2;

public class Kilometers implements Distance {
    private final double km;

    public Kilometers(double km) {
        this.km = km;
    }

    @Override
    public double calculateSpeed(double speed) {
        double speedKm = km / speed;
        System.out.println("Speed in km/h: " + speedKm);
        return speedKm;
    }
}

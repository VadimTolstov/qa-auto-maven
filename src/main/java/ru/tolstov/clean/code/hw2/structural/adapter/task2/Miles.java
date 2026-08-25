package ru.tolstov.clean.code.hw2.structural.adapter.task2;

public class Miles {
    private final double miles;

    public Miles(double miles) {
        this.miles = miles;
    }

    public double getMiles() {
        return miles;
    }

    public double convertMilesToKm() {
        double km = miles * 1.60934;
        System.out.println("Miles: " + " -> Km: " + km);
        return km;
    }
}

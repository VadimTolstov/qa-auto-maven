package ru.tolstov.clean.code.hw2.structural.adapter.task2;

public class MilesToKilometersAdapter implements Distance {
    private final Miles miles;

    public MilesToKilometersAdapter(Miles miles) {
        this.miles = miles;
    }


    @Override
    public double calculateSpeed(double speed) {
        System.out.println("Adapter is converting miles to kilometers");
        return miles.getMiles() * 1.609344 / speed;
    }
}

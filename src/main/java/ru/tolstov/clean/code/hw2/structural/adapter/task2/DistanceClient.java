package ru.tolstov.clean.code.hw2.structural.adapter.task2;

public class DistanceClient {
    private final Distance distance;

    public DistanceClient(Distance distance) {
        this.distance = distance;
    }

    public double run(double speed) {
        return distance.calculateSpeed(speed);
    }
}

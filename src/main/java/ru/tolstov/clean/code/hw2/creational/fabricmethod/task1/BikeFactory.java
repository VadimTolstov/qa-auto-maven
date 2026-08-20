package ru.tolstov.clean.code.hw2.creational.fabricmethod.task1;

public class BikeFactory implements TransportFactory{
    @Override
    public Transport createTransport() {
        return new Bike();
    }
}

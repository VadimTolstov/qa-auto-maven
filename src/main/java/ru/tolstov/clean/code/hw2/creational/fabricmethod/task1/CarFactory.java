package ru.tolstov.clean.code.hw2.creational.fabricmethod.task1;

public class CarFactory implements TransportFactory{
    @Override
    public Transport createTransport() {
        return new Car();
    }
}

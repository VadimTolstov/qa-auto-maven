package ru.tolstov.clean.code.hw2.creational.fabricmethod.task1;

public class Main {
    public static void main(String[] args) {
        TransportFactoryRegistry.register(TransportType.CAR, CarFactory::new);
        TransportFactoryRegistry.register(TransportType.BIKE, BikeFactory::new);

        TransportFactory factory = TransportFactoryRegistry.getFactory(TransportType.CAR);
        TransportFactory factory3 = TransportFactoryRegistry.getFactory(TransportType.CAR);
        System.out.println("Это один и тот же объект ?  " + (factory == factory3));

        Transport transport = factory.createTransport();
        transport.deliver();

        TransportFactory factory2 = TransportFactoryRegistry.getFactory(TransportType.BIKE);
        Transport transport2 = factory2.createTransport();
        transport2.deliver();
    }
}

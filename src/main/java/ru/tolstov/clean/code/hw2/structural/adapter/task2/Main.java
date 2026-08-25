package ru.tolstov.clean.code.hw2.structural.adapter.task2;

public class Main {
    public static void main(String[] args) {
        Distance distance = new Kilometers(200);
        DistanceClient client = new DistanceClient(distance);
        System.out.println(client.run(10));

        System.out.println("============================================");

        Miles miles = new Miles(2000);
        MilesToKilometersAdapter adapter = new MilesToKilometersAdapter(miles);
        client = new DistanceClient(adapter);
        System.out.println(client.run(10));
    }
}

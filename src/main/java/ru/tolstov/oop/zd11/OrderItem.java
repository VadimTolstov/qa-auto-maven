package ru.tolstov.oop.zd11;

public class OrderItem {
    private String name;
    private final double price;
    private int count;

    public OrderItem(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public double getTotal() {
        return price * count;
    }
}

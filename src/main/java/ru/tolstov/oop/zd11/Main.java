package ru.tolstov.oop.zd11;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("A123A");
        order.addItem(new OrderItem("Ноут",24.25,4));
        order.addItem(new OrderItem("Книга",100.00,1));
        order.addItem(new OrderItem("TV",150.50,4));
        System.out.println(order.calculateTotal());
    }
}

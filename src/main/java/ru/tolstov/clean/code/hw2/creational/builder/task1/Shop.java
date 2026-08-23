package ru.tolstov.clean.code.hw2.creational.builder.task1;

public class Shop {
    public static void main(String[] args) {
        Order order1 = new Order.OrderBuilder()
                .setDiscount(1)
                .setProduct("Apple","Banana")
                .setProduct("Orange")
                .setPaymentMethod(PaymentMethod.CASH)
                .build();

        Order order2 = new Order.OrderBuilder()
                .setDiscount(10)
                .setProduct("MacBook")
                .build();
        System.out.println(order1);
        System.out.println(order2);

    }
}

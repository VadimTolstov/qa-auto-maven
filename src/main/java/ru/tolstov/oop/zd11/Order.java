package ru.tolstov.oop.zd11;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public String getOrderId() {
        return orderId;
    }

    public double calculateTotal() {
        return orderItems.stream().mapToDouble(OrderItem::getTotal).sum();
    }
}

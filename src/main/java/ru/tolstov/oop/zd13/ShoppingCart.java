package ru.tolstov.oop.zd13;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> basket;

    public ShoppingCart() {
        this.basket = new ArrayList<>();
    }

    public void addProduct(Product product, int count) {
        for (CartItem c : basket) {
            if (c.getProduct().equals(product)) {
                c.changeQuantity(c.getQuantity() + count);
                return;
            }
        }
        basket.add(new CartItem(product, count));
    }

    public void removeProduct(String productName) {
        basket.removeIf(p -> p.getProduct().getName().equals(productName));
    }

    public void changeQuantity(String productName, int quantity) {
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i).getProduct().getName().equals(productName)) {
                if (quantity <= 0) {
                    basket.remove(i);
                } else {
                    basket.get(i).changeQuantity(quantity);
                }
                return;
            }
        }
    }

    public double calculateTotal() {
        return basket.stream().mapToDouble(CartItem::getTotal).sum();
    }

    public void showItems() {
        basket.forEach(System.out::println);
    }
}

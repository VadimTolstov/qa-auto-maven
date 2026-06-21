package ru.tolstov.hw12.warehouseInventory;

import java.util.Objects;

public record Product(String productName, double price, String category) {
    public Product {
        if (Objects.isNull(productName) || productName.isBlank() || Objects.isNull(category) || category.isBlank()) {
            throw new IllegalArgumentException("product name or category price can not be empty or null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price не может быть меньше 0, передан price: " + price);
        }
    }
}

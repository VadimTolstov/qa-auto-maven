package ru.tolstov.oop.zd13;

import java.util.Objects;

public class Product {
    private final String name;
    private final double price;
    private final String sku;

    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, sku);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                '}';
    }
}

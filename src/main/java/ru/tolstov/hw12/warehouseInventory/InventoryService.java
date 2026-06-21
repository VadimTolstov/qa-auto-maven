package ru.tolstov.hw12.warehouseInventory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InventoryService {
    private volatile boolean isInventoryOpen;
    private final Map<String, List<Product>> inventory = new ConcurrentHashMap<>();

    public void setInventoryOpen(boolean inventoryOpen) {
        isInventoryOpen = inventoryOpen;
    }

    public void addProduct(Product product) {
        Objects.requireNonNull(product, "product не должен быть null");
        if (isInventoryOpen) {
            inventory.computeIfAbsent(product.category(), p -> new CopyOnWriteArrayList<>()).add(product);
        } else {
            System.out.printf("Доступ к сладу закрыт, продукт %s не добавлен%n", product.productName());
        }
    }

    public List<Product> getProductsByCategory(String category) {
        Objects.requireNonNull(category, "Категория для поиска не должна быть null");
        if (!isInventoryOpen) {
            throw new IllegalArgumentException("Доступ к сладу закрыт");
        }
        return List.copyOf(inventory.entrySet().stream()
                .filter(entry -> Objects.nonNull(entry.getKey()) && Objects.equals(category, entry.getKey()))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(() -> new OutOfStockException("На складе нет категории: " + category)));
    }

    public List<Product> getProductsByPrice(double price) {
        return inventory.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(p -> Double.compare(p.price(), price) == 0)
                .collect(Collectors.toList());
    }
}

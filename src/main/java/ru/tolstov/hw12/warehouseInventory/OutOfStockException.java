package ru.tolstov.hw12.warehouseInventory;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}

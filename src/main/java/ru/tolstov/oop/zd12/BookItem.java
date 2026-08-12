package ru.tolstov.oop.zd12;

public class BookItem {
    private final Book book;
    private final String inventoryCode;
    private BookStatus status;

    public BookItem(Book book, String inventoryCode) {
        this.book = book;
        this.inventoryCode = inventoryCode;
        status = BookStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    public void lend() {
        if (status == BookStatus.AVAILABLE) {
            status = BookStatus.LEND;
        } else {
            System.out.println("Ошибка: Книга " + book.getTitle() + " (инв. №" + inventoryCode + ") недоступна для выдачи.");
        }
    }

    public void returnBack() {
        status = BookStatus.AVAILABLE;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return book.toString() + " — Инв. №" + inventoryCode + " (" + status + ")";
    }
}

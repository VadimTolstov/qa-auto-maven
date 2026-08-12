package ru.tolstov.oop.zd12;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final List<BookItem> items;

    public Library(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public void addBook(Book book, String inventoryCode) {
        BookItem item = new BookItem(book, inventoryCode);
        items.add(item);
    }


    public void lendBook(String title) {
        for (BookItem item : items) {
            if (item.getBook().getTitle().equals(title) && item.isAvailable()) {
                item.lend();
                System.out.println("Выдана книга: " + item.getBook().getTitle() + " (инв. №" + item.getInventoryCode() + ")");
                break;
            }
        }
    }

    public void returnBook(String inventoryCode) {
        for (BookItem item : items) {
            if (item.getInventoryCode().equals(inventoryCode)) {
                item.returnBack();
                System.out.println("Возвращена книга: " + item.getBook().getTitle());
                break;
            }
        }
        System.out.println("Книга с инв. номером " + inventoryCode + " не найдена.");
    }

    public void showAvailableBooks() {
        System.out.println("\n--- Доступные книги в библиотеке \"" + name + "\" ---");
        boolean found = false;
        for (BookItem item : items) {
            if (item.isAvailable()) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нет доступных книг.");
        }
        System.out.println("---------------------------------------------------");
    }
}


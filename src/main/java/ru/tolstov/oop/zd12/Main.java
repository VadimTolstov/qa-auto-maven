package ru.tolstov.oop.zd12;

public class Main {
    public static void main(String[] args) {
        // Создаем библиотеку
        Library library = new Library("Главная городская библиотека");

        // Создаем книги (автор, название, isbn)
        Book book1984 = new Book("1984", "Оруэлл", "978-0-452-28423-4");
        Book bookMaster = new Book("Мастер и Маргарита", "Булгаков", "978-5-699-14504-6");

        // Добавляем книги в библиотеку с инвентарными номерами
        // Как в примере: 1984 - 2 экземпляра, Мастер и Маргарита - 1 экземпляр
        library.addBook(book1984, "INV-001");
        library.addBook(book1984, "INV-002");
        library.addBook(bookMaster, "INV-003");

        // Показываем доступные книги (изначально все доступны)
        library.showAvailableBooks();

        // Выдаём книгу (происходит 1 выдача) -> "1984" - 1
        System.out.println("\n--- Процесс выдачи ---");
        library.lendBook("1984");

        // Проверяем доступные книги (должна остаться 1 шт. 1984 и 1 шт. Мастер)
        library.showAvailableBooks();

        // Возвращаем книгу по инвентарному номеру
        System.out.println("\n--- Процесс возврата ---");
        library.returnBook("INV-001");

        // Проверяем финальное состояние (снова 2 шт. 1984 и 1 шт. Мастер)
        library.showAvailableBooks();
    }
}

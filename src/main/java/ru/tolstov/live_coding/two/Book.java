package ru.tolstov.live_coding.two;

import java.util.Objects;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book book)) {
            return false;
        }
        return Objects.equals(book.author, author) && Objects.equals(book.title, title);
    }



//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Book book)) return false;
//        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, author);
//    }
}

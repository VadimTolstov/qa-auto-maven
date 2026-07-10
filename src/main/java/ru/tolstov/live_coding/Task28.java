package ru.tolstov.live_coding;

import java.util.Objects;

public class Task28 {
    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (o == null || getClass() != o.getClass()) return false;
//            Book book = (Book) o;
//            return Objects.equals(title, book.title) && Objects.equals(author, book.author);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(title, author);
//        }


        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Book book)) return false;
            return Objects.equals(title, book.title) && Objects.equals(author, book.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, author);
        }
    }
}

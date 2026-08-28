package ru.tolstov.clean.code.hw3.task3;

public class BookProxy {
    private Book book;
    private String cover;
    private String author;
    private String description;
    private String content;

    public BookProxy(Book book) {
        this.book = book;
    }

    public String getCover() {
        if (cover == null) {
            cover = book.getCover();
        }
        return cover;
    }

    public String getAuthor() {
        if (author == null) {
            author = book.getAuthor();
        }
        return author;
    }

    public String getDescription() {
        if (description == null) {
            description = book.getDescription();
        }
        return description;
    }

    public String getContent() {
        if (content == null) {
            content = book.getContent();
        }
        return content;
    }

    @Override
    public String toString() {
        return "BookProxy{" +
                "cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

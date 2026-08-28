package ru.tolstov.clean.code.hw3.task3;

public class Book {
    private String cover;
    private String author;
    private String description;
    private String content;

    private Book(BookBuilder bookBuilder) {
        this.cover = bookBuilder.cover;
        this.author = bookBuilder.author;
        this.description = bookBuilder.description;
        this.content = bookBuilder.content;
    }

    public String getCover() {
        return cover;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Book{" +
                "cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    static class BookBuilder {
        private String cover;
        private String author;
        private String description;
        private String content;

        public BookBuilder setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BookBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

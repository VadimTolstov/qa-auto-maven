package ru.tolstov.clean.code.hw3.task3;

public class Main {
    public static void main(String[] args) {
        Book book = new Book.BookBuilder()
                .setAuthor("Author")
                .setContent("Content")
                .setDescription("Description")
                .setCover("Cover")
                .build();
        BookProxy proxy = new BookProxy(book);

        System.out.println(proxy.toString());

        System.out.println(proxy.getAuthor());
        System.out.println(proxy.getContent());
        System.out.println(proxy.getCover());
        System.out.println(proxy.getDescription());

        System.out.println(proxy.toString());
    }
}

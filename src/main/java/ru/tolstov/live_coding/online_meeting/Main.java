package ru.tolstov.live_coding.online_meeting;

public class Main {

    public static void main(String[] args) {
        Book book = new Book();

        book.addContact(new Contact("Alex", "12345"));
        book.addContact(new Contact("Alex", "324"));
        book.addContact(new Contact("Maria", "77777"));
        System.out.println(book.getContact("Alex"));
        System.out.println(book.sizeContact());
        System.out.println(book.isThereContact("Alex"));
        System.out.println(book.getContact("Maria"));

        book.removeContact("Alex");
        System.out.println(book.sizeContact());
    }
}

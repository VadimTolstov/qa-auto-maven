package ru.tolstov.live_coding.online_meeting;

import java.util.HashSet;
import java.util.Set;

/*
В системе есть телефонная книга.
Телефонная книга хранит контакты.
У каждого контакта есть:
имя
номер телефона
Нужно реализовать систему, которая может:
добавить контакт
удалить контакт
найти номер по имени
проверить, существует ли контакт
показать количество контактов

Правила:
имя контакта уникально
если контакт с таким именем уже существует, номер должен обновляться
если контакт удален, его нельзя найти

Пример:
Добавляем контакты:
Alex → 12345
Maria → 77777

Поиск:
Alex → 12345

Удаляем:
Maria

Количество контактов:
1
 */
public class Book {
    private final Set<Contact> contactsSet = new HashSet<>();


    public void addContact(Contact contacts) {
        if (contactsSet.contains(contacts)) {
            System.out.println("Обновляем номер контакта");
            contactsSet.remove(contacts);
            contactsSet.add(contacts);
        } else {
            contactsSet.add(contacts);
            System.out.println("Добавляем новый контакт");
        }
    }

    public void removeContact(String name) {
        Contact contacts = contactsSet.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .get();
        contactsSet.remove(contacts);
        System.out.println("Удаляем контакт по имени " + name);
    }

    public String getContact(String name) {
        Contact contacts = contactsSet.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .get();
        System.out.println("Получаем номер телефона : " + contacts.getPhone() + " контакт по имени " + name);
        return contacts.getPhone();
    }

    public boolean isThereContact(String name) {
        System.out.println("Проеверяем");
        return contactsSet.stream()
                .anyMatch(contacts -> contacts.getName().equals(name));
    }

    public int sizeContact() {
        return contactsSet.size();
    }
}

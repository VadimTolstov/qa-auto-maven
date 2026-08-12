package ru.tolstov.live_coding.online_meeting;

import java.util.Objects;

public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contact contacts)) return false;
        return Objects.equals(name, contacts.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

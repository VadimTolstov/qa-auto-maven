package ru.tolstov.clean.code.hw1.task8;

class EmailSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("Отправка email: " + message);
    }
}

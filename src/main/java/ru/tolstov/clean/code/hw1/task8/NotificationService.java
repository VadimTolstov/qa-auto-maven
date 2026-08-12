package ru.tolstov.clean.code.hw1.task8;

public class NotificationService {
    private final NotificationSender notificationSender;

    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void sendNotification(String message) {
        notificationSender.send(message);
    }
}

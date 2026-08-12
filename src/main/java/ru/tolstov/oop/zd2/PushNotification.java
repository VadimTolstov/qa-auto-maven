package ru.tolstov.oop.zd2;

public class PushNotification implements Notification {
    private String recipient;
    private String message;

    public PushNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Push отправлено на device-" + recipient + ": " + message);
    }
}

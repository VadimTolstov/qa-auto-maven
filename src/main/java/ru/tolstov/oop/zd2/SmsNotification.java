package ru.tolstov.oop.zd2;

public class SmsNotification implements Notification {
    private String recipient;
    private String message;

    public SmsNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("SMS отправлено на " + recipient + ": " + message);
    }
}

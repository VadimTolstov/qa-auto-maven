package ru.tolstov.oop.zd2;

import java.util.ArrayList;
import java.util.List;

public class SalaryService {
    private static List<Notification> notificationList = new ArrayList<>();

    public static void addSalary(Notification notification){
        notificationList.add(notification);
    }

    public static void sendAll(){
        notificationList.forEach(Notification::send);
    }

    public static void main(String[] args) {
        addSalary(new SmsNotification("+123456789", "Код подтверждения 1234"));
        addSalary(new EmailNotification("alex@test.com", "Ваш заказ готов"));
        addSalary(new PushNotification("777", "У вас новое сообщение"));
        sendAll();
    }
}

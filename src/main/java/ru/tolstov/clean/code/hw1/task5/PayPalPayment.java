package ru.tolstov.clean.code.hw1.task5;

public class PayPalPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Оплата через PayPal на сумму " + amount);
    }
}

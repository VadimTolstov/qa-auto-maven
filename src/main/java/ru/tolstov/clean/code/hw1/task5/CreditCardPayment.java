package ru.tolstov.clean.code.hw1.task5;

public class CreditCardPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Оплата кредитной картой на сумму " + amount);
    }
}

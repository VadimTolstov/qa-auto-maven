package ru.tolstov.clean.code.hw1.task5;

public class BitcoinPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Оплата Bitcoin на сумму " + amount);
    }
}

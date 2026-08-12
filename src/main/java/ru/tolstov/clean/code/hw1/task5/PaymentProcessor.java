package ru.tolstov.clean.code.hw1.task5;

public class PaymentProcessor {
    public void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}

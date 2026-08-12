package ru.tolstov.oop.zd1;

public class HourlyEmployee extends Employee {
    private final double bet;
    private final int time;

    public HourlyEmployee(String name, double bet, int time) {
        super(name);
        this.bet = bet;
        this.time = time;
    }

    @Override
    public double calculateSalary() {
        return bet * time;
    }
}

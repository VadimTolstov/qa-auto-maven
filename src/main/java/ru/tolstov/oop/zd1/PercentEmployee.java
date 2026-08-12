package ru.tolstov.oop.zd1;

public class PercentEmployee extends Employee {
    private final double sales;
    private final int percentage;

    public PercentEmployee(String name, double sales, int percentage) {
        super(name);
        this.sales = sales;
        this.percentage = percentage;
    }

    @Override
    public double calculateSalary() {
        return sales / 100 * percentage;
    }
}

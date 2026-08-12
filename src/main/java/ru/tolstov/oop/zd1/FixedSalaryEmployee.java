package ru.tolstov.oop.zd1;

public class FixedSalaryEmployee extends Employee {
    private final double monthlySalary;

    public FixedSalaryEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

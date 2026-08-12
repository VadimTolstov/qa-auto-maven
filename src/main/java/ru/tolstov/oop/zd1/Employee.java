package ru.tolstov.oop.zd1;

public abstract class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    abstract double calculateSalary();

    public String getName() {
        return name;
    }
}

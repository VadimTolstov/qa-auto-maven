package ru.tolstov.oop.zd1;

import java.util.ArrayList;
import java.util.List;

public class SalaryService {
    public static void payAll(List<Employee> employees) {
        employees.forEach(e -> System.out.println(e.getName() + " получила " + e.calculateSalary()));
    }

    public static void main(String[] args) {
        Employee fixed = new FixedSalaryEmployee("Анна", 3000);
        Employee hourly = new HourlyEmployee("Борис", 240, 10);
        Employee percent = new PercentEmployee("Мария", 50000,10);
        List<Employee> employees = new ArrayList<>();
        employees.add(fixed);
        employees.add(hourly);
        employees.add(percent);
        payAll(employees);
    }
}

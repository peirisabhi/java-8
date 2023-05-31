package org.example.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 19/05/2023
 * Time: 15:37
 */
public class Ex2 {
    public static void main(String[] args) {

        List<Employee> employeeList = Stream.of(
                new Employee(1, "abc", "HR", 10000),
                new Employee(2, "def", "HR", 15000),
                new Employee(3, "ab", "HR", 19000),
                new Employee(4, "bc", "DEV", 20000),
                new Employee(5, "xyz", "DEV", 23000),
                new Employee(6, "hg", "FIN", 25000)
        ).collect(Collectors.toList());


        // way 1
        Comparator<Employee> employeeSalarayComparator = Comparator.comparing(Employee::getSalary);

        Map<String, Optional<Employee>> listMap = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.reducing(BinaryOperator.maxBy(employeeSalarayComparator))
        ));

        System.out.println(listMap);


        // way 2
        Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)
        ));

        System.out.println(employeeMap);
    }
}


class Employee{
    int id;
    String name;

    String dept;

    double salary;

    public Employee() {
    }

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
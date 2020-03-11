package main.java.Question5;

public class Employee {
    String name;
    int age;
    int salary;
    String address;

    public Employee(String name, int age, int salary, String address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
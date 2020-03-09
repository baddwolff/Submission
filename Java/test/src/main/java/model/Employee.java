package main.java.model;

import main.java.main;

public class Employee {

    int id;
    String employeeName;
    int hoursWorked;
    String employeeJob;
    int salary;

    public Employee() {

    }

    public Employee(String employeeName, String employeeJob,int hoursWorked,int salary) {
        this.employeeName = employeeName;
        this.employeeJob = employeeJob;
        this.hoursWorked = hoursWorked;
        this.salary=salary;
    }

    public Employee(int id, String employeeName, int hoursWorked, String employeeJob,int salary) {
        this.id = id;
        this.employeeName = employeeName;
        this.hoursWorked = hoursWorked;
        this.employeeJob = employeeJob;

    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

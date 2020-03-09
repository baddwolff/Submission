package main.java.service;

import main.java.model.Employee;

public interface EmployeeServiceInterface {

    public void registerEmployee(Employee employee);

    public void updateWorkingHours(Employee employee,int hours);

    public void payEmployee(Employee employee);

    public void retireEmployee(Employee employee);
}

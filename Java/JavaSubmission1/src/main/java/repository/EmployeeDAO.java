package main.java.repository;

import main.java.main;
import main.java.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    //Create
    public void save(Employee employee);
    //Read
    public Employee getById(int id);
    //UpdateHours
    public void updateHours(Employee employee);

    //Delete
    public void deleteById(int id);
    //Get All
    public List<Employee> findAll();


}


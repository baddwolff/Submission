package main.java.Question3;

import java.util.List;

public class Department {
    int id;
    List<Employee> employeeList;

    public Department(int id, List<Employee> employeeList) {
        this.id = id;
        this.employeeList = employeeList;
    }

    public Department() {

    }

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

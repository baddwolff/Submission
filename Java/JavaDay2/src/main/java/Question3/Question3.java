package main.java.Question3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question3 {
    public static void main(String args[]){
        Department management=new Department(1,new ArrayList<>());
        Department developers =new Department(2, new ArrayList<>());
        Department humanResources=new Department(3,new ArrayList<>());

        management.addEmployee(new Employee("Pradeep",management.getId(),20));
        management.addEmployee(new Employee("RaviTeja",management.getId(),10));
        management.addEmployee(new Employee("Amith",management.getId(),30));

        developers.addEmployee(new Employee("Aditya",developers.getId(),1));
        developers.addEmployee(new Employee("Ashish",developers.getId(),2));
        developers.addEmployee(new Employee("Sanjay",developers.getId(),3));
        developers.addEmployee(new Employee("Satyam",developers.getId(),4));

        humanResources.addEmployee(new Employee("Alex",humanResources.getId(),35));
        humanResources.addEmployee(new Employee("Sumpa",humanResources.getId(),15));
        List<Employee> employeeList=new ArrayList<>();
        management.getEmployeeList().forEach(item->employeeList.add(item));
        developers.getEmployeeList().forEach(item->employeeList.add(item));
        humanResources.getEmployeeList().forEach(item->employeeList.add(item));

//        employeeList.forEach(item->System.out.println(item.toString()));
        System.out.println("Sorted By Department");
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId)
                        .thenComparing(Comparator.comparingInt(Employee::getExperience).reversed())
                        .thenComparing(Comparator.comparing(Employee::getName)))
                .forEach(item->System.out.println(item.toString()));




    }
}

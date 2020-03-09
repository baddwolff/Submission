package main.java.service;

import main.java.model.Employee;
import main.java.repository.EmployeeDAO;
import main.java.repository.EmployeeMySqlDAO;
import main.java.repository.EmployeePostGreSqlDAO;

public class EmployeeService implements EmployeeServiceInterface {

    EmployeeDAO mysqlDAO= new EmployeeMySqlDAO();
    EmployeeDAO postgresDAO = new EmployeePostGreSqlDAO();
    IdGeneratorService idGeneratorService=new IdGeneratorService(0);

    @Override
    public void registerEmployee(Employee employee){
        int newId= idGeneratorService.getCurrentIdValue();
        idGeneratorService.setCurrentIdValue(idGeneratorService.getCurrentIdValue()+1);
        employee.setId(newId);
        if(newId<=1000){
            mysqlDAO.save(employee);
        }
        else {
            postgresDAO.save(employee);
        }
    }
    @Override
    public void updateWorkingHours(Employee employee,int hours){
        employee.setHoursWorked(hours);
        if(employee.getId()<=1000){
            mysqlDAO.updateHours(employee);
        }
        else {
            postgresDAO.updateHours(employee);
        }

    }
    @Override
    public void payEmployee(Employee employee){
        employee.setHoursWorked(0);
        System.out.println("Employee has been paid amount salary amount:"+employee.getSalary()*employee.getHoursWorked());
        if(employee.getId()<=1000){
            mysqlDAO.updateHours(employee);
        }
        else {
            postgresDAO.updateHours(employee);
        }

    }
    @Override
    public void retireEmployee(Employee employee){
        if(employee.getId()<=1000){
            mysqlDAO.deleteById(employee.getId());
        }
        else {
            postgresDAO.deleteById(employee.getId());
        }

    }

}

package main.java.repository;

import main.java.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMySqlDAO implements EmployeeDAO {


    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void save(Employee employee) {

        String query ="INSERT INTO Employee (id,name,job,hours_worked,salary) VALUES (?,?,?,?);";
        Connection con = null;
        PreparedStatement ps = null;
        try{

            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1,employee.getId());
            ps.setString(2,employee.getEmployeeName());
            ps.setString(3, employee.getEmployeeJob());
            ps.setInt(4, employee.getHoursWorked());
            ps.setInt(4, employee.getHoursWorked());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Saved");
            }else System.out.println("Failed");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee getById(int id) {

        String query ="Select * from Employee where id=?;";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            int out = ps.executeUpdate();
            while(rs.next()){
                Employee employee =new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("hours_worked"),rs.getString("job"),rs.getInt("salary"));
                return employee;
            }
            if(out !=0){
                System.out.println("Saved");
            }else System.out.println("Failed");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;


    }

    @Override
    public void updateHours(Employee employee) {
        String query = "update Employee set hours_worked=? where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, employee.getHoursWorked());
            ps.setInt(2, employee.getId());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("found");
            }else System.out.println("empty");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from Orders where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Order deleted with id="+id);
            }else System.out.println("No Order found with id="+id);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        String query = "select * from Orders";
        List<Employee> list = new ArrayList<Employee>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee employee =new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("hours_worked"),rs.getString("job"),rs.getInt("salary"));

                list.add(employee);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }



}

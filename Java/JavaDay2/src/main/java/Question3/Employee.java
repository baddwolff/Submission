package main.java.Question3;

public class Employee {
    String name;
    int departmentId;
    int experience;

    public Employee(String name, int departmentId, int experience) {
        this.name = name;
        this.departmentId = departmentId;
        this.experience = experience;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", experience=" + experience +
                '}';
    }
}

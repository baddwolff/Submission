package main.java.Question1;

import java.time.LocalDate;
import java.util.List;

final public class Person {
    private String name;
    private LocalDate dataOfBirth;
    private List<String> hobbies;

    public Person(){

    }

    public Person(String name, LocalDate dataOfBirth, List<String> hobbies) {
        this.name = name;
        this.dataOfBirth = dataOfBirth;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobbies(String hobby) {
        this.hobbies.add(hobby);
    }
}

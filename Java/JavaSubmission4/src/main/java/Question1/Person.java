package main.java.Question1;

import java.time.LocalDate;
import java.util.List;

public class Person {

    int id;
    LocalDate date_of_Birth;
    List<String> List_of_Jobs;

    public Person(int id, LocalDate date_of_Birth, List<String> list_of_Jobs) {
        this.id = id;
        this.date_of_Birth = date_of_Birth;
        List_of_Jobs = list_of_Jobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate_of_Birth() {
        return date_of_Birth;
    }

    public void setDate_of_Birth(LocalDate date_of_Birth) {
        this.date_of_Birth = date_of_Birth;
    }

    public List<String> getList_of_Jobs() {
        return List_of_Jobs;
    }

    public void setList_of_Jobs(List<String> list_of_Jobs) {
        List_of_Jobs = list_of_Jobs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", date_of_Birth=" + date_of_Birth +
                ", List_of_Jobs=" + List_of_Jobs +
                '}';
    }
}

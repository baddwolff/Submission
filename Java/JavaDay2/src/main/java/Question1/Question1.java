package main.java.Question1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Question1 {

    public static void main(String args[]){
        LocalDate dob=LocalDate.now();
        List<String> hobbies=new ArrayList<>();
        hobbies.add("video games");
        hobbies.add("music");
        Person person=new Person("Aditya",dob,hobbies);
        Person person2=new Person("NotAditya",dob,hobbies);
        person=person2;
    }
}

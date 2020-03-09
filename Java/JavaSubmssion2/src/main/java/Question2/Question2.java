package main.java.Question2;

import main.java.Question1.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public static void main(String args[]){
        List<String> empployeeList =new ArrayList<>();
        empployeeList.add("aditya,21,50000,bengaluru");
        empployeeList.add("satyam,22,10000,bengaluru");
        empployeeList.add("sanjay,23,20000,bengaluru");
        empployeeList.add("ashish,24,30000,bengaluru");
        empployeeList.add("srejit,31,40000,bengaluru");

         empployeeList
                .stream()
                .map(item->{
                    String[] array = item.split(",");
                    return array;
                })
                .filter(item->{
                    int age=Integer.parseInt(item[1]);
                    return  age>=22 && age<=30;
                })
                .mapToInt(item->{
                    return Integer.parseInt(item[2]);
                })
                .average()
                .ifPresent(System.out::println);

    }
}

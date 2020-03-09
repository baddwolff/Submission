package main.java.Question5;

import main.java.Question4.Employee;
import main.java.Question4.ModifierThread;
import main.java.Question4.ReaderThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question5 {

    public static void main(String args[]){
        List<Employee> ls =
                Collections.synchronizedList(new ArrayList<Employee>());
        ls.add(new Employee("a",1,1,"b"));
        ReaderThread ob1= new ReaderThread(ls);
        ModifierThread2 ob2 =new ModifierThread2(ls);
        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
        t1.start();
        t2.start();

    }
}

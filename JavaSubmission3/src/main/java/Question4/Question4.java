package main.java.Question4;

import java.util.ArrayList;
import java.util.List;

public class Question4 {
    public static volatile List<Employee> ls= new ArrayList<>();
    public static void main(String args[]){
        ls.add(new Employee("a",1,1,"b"));
        ReaderThread ob1= new ReaderThread(ls);
        ModifierThread ob2 =new ModifierThread(ls);
        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
        t1.start();
        t2.start();

    }

}

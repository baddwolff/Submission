package main.java.Question5;

import main.java.Question4.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ModifierThread2 implements Runnable {

    List ls;
    public ModifierThread2(List<Employee> ls){
        this.ls=ls;
    }
    @Override
    public void run() {
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter 0/1:");
            int i=in.nextInt();
            synchronized (ls){

                if(i==1){
                    System.out.println("adding");
                    ls.add(new Employee("a",1,1,"b"));
                }
                if (i==0){
                    Iterator iter = ls.iterator();
                    if (iter == null) {
                        System.exit(1);
                    }
                    while (iter.hasNext()) {
//                        System.out.println(iter.next());
                        iter.next();
                        iter.remove();
                        System.out.println("removed");
                    }
                }

            }
            System.out.println("out");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

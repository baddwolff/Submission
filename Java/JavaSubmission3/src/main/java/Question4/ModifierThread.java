package main.java.Question4;

import java.util.List;

public class ModifierThread implements Runnable {
    List ls;
    public ModifierThread(List<Employee> ls){
        this.ls=ls;
    }
    @Override
    public void run() {
        while (true){
            synchronized (ls){
                ls.add(new Employee("a",1,1,"b"));
                System.out.println("added");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

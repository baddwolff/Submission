package main.java.Question3;

import main.java.Question2.PrintThread;
import main.java.Question2.haveAccess;

public class Question3 {
    public static void main(String args[]){
        Printer print=new Printer(true);

        SkipCounterThread ob1=new SkipCounterThread(1,print);
        SkipCounterThread ob2=new SkipCounterThread(2,print);
        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
        t1.start();
        t2.start();

    }
}

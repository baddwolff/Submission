package main.java.Question4;

import java.util.Iterator;
import java.util.List;

public class ReaderThread implements Runnable{
    List ls;
    public ReaderThread(List<Employee> ls){
        this.ls=ls;
    }
    @Override
    public void run() {
        while (true){
            synchronized (ls){
                System.out.println("printing");
                Iterator iter = ls.iterator();
                if(iter == null){
                    System.exit(1);
                }
                while(iter.hasNext()){
                    System.out.println(iter.next().toString());

                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package main.java.Question4;

import java.util.List;

public class ReaderThread implements Runnable{
    List ls;
    ReaderThread(List<Employee> ls){
        this.ls=ls;
    }
    @Override
    public void run() {
        while (true){
            ls.forEach(item->item.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

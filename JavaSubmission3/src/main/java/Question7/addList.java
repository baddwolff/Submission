package main.java.Question7;

import java.util.List;

public class addList implements Runnable {
    SharedList ls;

    public addList(SharedList ls) {
        this.ls = ls;
    }

    @Override
    public void run() {
        int i=0;
        try {
            while (true){
                ls.addList(i);
                System.out.println("added");
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println("Interrupted exception " + e);
        }

    }
}

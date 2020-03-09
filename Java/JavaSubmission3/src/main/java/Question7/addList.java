package main.java.Question7;

import java.util.List;

public class addList implements Runnable {
    List<Integer> ls;

    public addList(List<Integer> ls) {
        this.ls = ls;
    }

    @Override
    public void run() {
        while (true){
            synchronized (ls){
                int i=0;
                try {
                    ls.add(i);

                    System.out.println("added");
                }
                catch(Exception e)
                {
                    System.out.println("Interrupted exception " + e);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
